package com.waas.callbackServer.dto;

public abstract class absRequest implements iRequest {
    private String sign;

    @Override
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
