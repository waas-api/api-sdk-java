package com.waas.callbackServer.dto;

public class depositResponse extends absResponse {

    protected successData data;

    public depositResponse() {
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
