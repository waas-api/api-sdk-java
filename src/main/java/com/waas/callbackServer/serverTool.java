package com.waas.callbackServer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.sun.net.httpserver.HttpExchange;
import com.waas.callbackServer.dto.*;
import com.waas.crypto.rsaSigner;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class serverTool {
    private String platformPublicKey;
    private String privateKey;
    private rsaSigner singer;

    public serverTool(String platformPublicKey, String privateKey) {
        this.platformPublicKey = platformPublicKey;
        this.privateKey = privateKey;
        this.singer = new rsaSigner();
    }

    public depositRequest getDepositRequest(Reader r) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(r, depositRequest.class);
    }

    public withdrawRequest getWithdrawRequest(Reader r) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(r, withdrawRequest.class);
    }

    public withdrawRiskRequest getWithdrawRiskRequest(Reader r) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(r, withdrawRiskRequest.class);
    }

    public boolean verifySign(iRequest req) throws Exception {
        String dataStr = new GsonBuilder().create().toJson(req.getData());
        return this.singer.verifySign(JsonParser.parseString(dataStr), req.getSign(), this.platformPublicKey);
    }

    public void addSignToResponse(iResponse res) throws Exception {
        String sign = this.singer.genSign(res.getData(), this.privateKey);
        res.setSign(sign);
    }

    public void writeResponse(HttpExchange httpExchange, iResponse res) throws IOException {
        Gson gson = new GsonBuilder().create();
        byte[] responseContentBytes = gson.toJson(res).getBytes(StandardCharsets.UTF_8);
        httpExchange.getResponseHeaders().add("Content-Type", "application/json");
        httpExchange.sendResponseHeaders(200, responseContentBytes.length);
        OutputStream out = httpExchange.getResponseBody();
        out.write(responseContentBytes);
        out.flush();
        out.close();
    }
}
