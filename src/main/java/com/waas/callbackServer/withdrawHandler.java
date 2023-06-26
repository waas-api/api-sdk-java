package com.waas.callbackServer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.waas.callbackServer.dto.withdrawRequest;
import com.waas.callbackServer.dto.withdrawResponse;

import java.io.InputStreamReader;

/**
 * an example HttpHandler implement for handle withdraw callback request
 */
public class withdrawHandler implements HttpHandler {

    private serverTool sTool;

    public withdrawHandler(serverTool tool) {
        this.sTool = tool;
    }

    @Override
    public void handle(HttpExchange httpExchange) {

        Gson gson = new GsonBuilder().create();
        withdrawResponse res = new withdrawResponse();

        try {

            // get request object
            withdrawRequest req = this.sTool.getWithdrawRequest(new InputStreamReader(httpExchange.getRequestBody()));
            System.out.println(gson.toJson(req));

            // verify request sign
            if (!this.sTool.verifySign(req)) {
                res.setStatus(500);
                this.sTool.writeResponse(httpExchange, res);
                return;
            }

            // TODO check info according to your needs

            // return success after all check is OK
            res.setStatus(200);
            res.getData().setSuccess_data("success");

            // gen sign and set to response object
            this.sTool.addSignToResponse(res);
            System.out.println(gson.toJson(res));

            this.sTool.writeResponse(httpExchange, res);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
