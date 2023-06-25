package com.waas.callbackServer.dto;

public class withdrawRiskResponse extends absResponse {

    private withdrawRiskResponseData data;

    public withdrawRiskResponse() {
        this.data = new withdrawRiskResponseData();
    }

    @Override
    public withdrawRiskResponseData getData() {
        return data;
    }

    public void setData(withdrawRiskResponseData data) {
        this.data = data;
    }

    public static class withdrawRiskResponseData {
        private int status_code;
        private long timestamp;
        private String order_id;

        public int getStatus_code() {
            return status_code;
        }

        public void setStatus_code(int status_code) {
            this.status_code = status_code;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }
    }


}
