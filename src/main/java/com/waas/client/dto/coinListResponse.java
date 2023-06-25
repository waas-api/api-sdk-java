package com.waas.client.dto;

public class coinListResponse extends baseResponse {

    private coinListData data;

    public Object getData() {
        return data;
    }

    public void setData(coinListData data) {
        this.data = data;
    }
}

