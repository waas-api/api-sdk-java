package com.waas.client.dto;

import java.util.List;

public class addressGetBatchResponse extends baseResponse {
    public List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
