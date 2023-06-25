package com.waas.client.dto;

public class transferResponse extends baseResponse {
    private transferData data;

    public transferData getData() {
        return data;
    }

    public void setData(transferData data) {
        this.data = data;
    }
}
