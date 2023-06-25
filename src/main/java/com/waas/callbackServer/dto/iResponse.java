package com.waas.callbackServer.dto;

public interface iResponse {
    int getStatus();

    Object getData();

    void setSign(String sign);
}
