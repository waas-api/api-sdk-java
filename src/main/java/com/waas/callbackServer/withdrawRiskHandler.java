package com.waas.callbackServer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.waas.callbackServer.dto.withdrawRiskRequest;
import com.waas.callbackServer.dto.withdrawRiskResponse;

import java.io.InputStreamReader;

/**
 * an example HttpHandler implement for handle withdraw ris callback request
 */
public class withdrawRiskHandler implements HttpHandler {

    private serverTool sTool;

    public withdrawRiskHandler(serverTool tool) {
        this.sTool = tool;
    }

    @Override
    public void handle(HttpExchange httpExchange) {

        Gson gson = new GsonBuilder().create();
        withdrawRiskResponse res = new withdrawRiskResponse();

        try {

            // get request object
            withdrawRiskRequest req = this.sTool.getWithdrawRiskRequest(new InputStreamReader(httpExchange.getRequestBody()));
            System.out.println(gson.toJson(req));

            // verify request sign
            if (!this.sTool.verifySign(req)) {
                res.setStatus(5400);
                this.sTool.writeResponse(httpExchange, res);
                return;
            }

            // TODO check info according to your needs

            // return success after all check is OK
            res.setStatus(200);
            res.getData().setStatus_code(200);
            res.getData().setOrder_id(req.getData().getOrder_id());
            res.getData().setTimestamp(System.currentTimeMillis() / 1000);

            // gen sign and set to response object
            this.sTool.addSignToResponse(res);
            System.out.println(gson.toJson(res));

            this.sTool.writeResponse(httpExchange, res);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
