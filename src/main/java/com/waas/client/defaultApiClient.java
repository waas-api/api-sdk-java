package com.waas.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.waas.client.dto.*;
import com.waas.crypto.rsaSigner;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class defaultApiClient implements iApiClient {

    private HttpClient httpClient;
    private final apiClientConfig config;
    private final Gson gson;

    public defaultApiClient(apiClientConfig config) {
        this(config, HttpClient.newHttpClient());
    }

    public defaultApiClient(apiClientConfig config, HttpClient httpClient) {
        this.httpClient = httpClient;
        this.config = config;
        this.gson = new GsonBuilder().create();
    }


    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }


    @Override
    public coinListResponse coinList(coinListRequest request) throws Exception {
        return this.doPost("/coin/list", request, coinListResponse.class);
    }

    @Override
    public addressGetBatchResponse addressGetBatch(addressGetBatchRequest request) throws Exception {
        return this.doPost("/address/getBatch", request, addressGetBatchResponse.class);
    }

    @Override
    public addressSyncStatusResponse addressSyncStatus(addressSyncStatusRequest request) throws Exception {
        return this.doPost("/address/syncStatus", request, addressSyncStatusResponse.class);
    }

    @Override
    public addressListResponse addressList(addressListRequest request) throws Exception {
        return this.doPost("/address/list", request, addressListResponse.class);
    }

    @Override
    public addressVerifyAddressResponse addressVerifyAddress(addressVerifyAddressRequest request) throws Exception {
        return this.doPost("/address/verifyAddress", request, addressVerifyAddressResponse.class);
    }

    @Override
    public transferResponse transfer(transferRequest request) throws Exception {
        return this.doPost("/transfer", request, transferResponse.class);
    }

    private <R> R doPost(String path, iRequest request, Class<R> classOfResponse) throws Exception {

        rsaSigner signer = new rsaSigner();

        request.setApp_id(this.config.appid);
        request.setVersion(this.config.version);
        request.setKey_version(this.config.keyVersion);
        request.setTime(Long.valueOf(System.currentTimeMillis() / 1000).toString());
        request.setSign(signer.genSign(request, this.config.privateKey));

        HttpRequest hr = HttpRequest.newBuilder().
                uri(URI.create(this.config.baseUrl + path)).
                POST(HttpRequest.BodyPublishers.ofString(this.gson.toJson(request))).
                build();

        //TODO
        System.out.println(this.gson.toJson(request));

        HttpResponse<String> httpResp = this.httpClient.send(hr, HttpResponse.BodyHandlers.ofString());

        if (httpResp.statusCode() != 200) {
            throw new Exception(String.format("http error[%d]: %s", httpResp.statusCode(), httpResp.body()));
        }

        //TODO
        System.out.println(httpResp.body());

        JsonObject jObject = JsonParser.parseString(httpResp.body()).getAsJsonObject();
        if (jObject.get("status").getAsInt() == 200) {
            boolean signOk = signer.verifySign(jObject, jObject.get("sign").getAsString(), this.config.platformPublicKey);
            if (!signOk) {
                throw new Exception("response verifySign fail:" + httpResp.body());
            }
        } else if (jObject.get("data").isJsonArray() && jObject.get("data").getAsJsonArray().isEmpty()) {
            jObject.remove("data");
        }

        return this.gson.fromJson(jObject, classOfResponse);
    }

}
