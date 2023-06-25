package com.waas.client.dto;

public class addressSyncStatusResponse extends baseResponse {
    private addressSyncStatusItem data;

    public addressSyncStatusItem getData() {
        return data;
    }

    public void setData(addressSyncStatusItem data) {
        this.data = data;
    }
}
