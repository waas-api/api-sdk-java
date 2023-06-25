package com.waas.callbackServer.dto;

public class withdrawResponse extends absResponse {

    protected successData data;

    public withdrawResponse() {
        this.data = new successData();
    }

    @Override
    public successData getData() {
        return this.data;
    }

    public void setData(successData data) {
        this.data = data;
    }
}
