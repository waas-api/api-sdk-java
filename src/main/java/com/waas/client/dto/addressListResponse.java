package com.waas.client.dto;

public class addressListResponse extends baseResponse {

    private addressListData data;

    public addressListData getData() {
        return data;
    }

    public void setData(addressListData data) {
        this.data = data;
    }
}
