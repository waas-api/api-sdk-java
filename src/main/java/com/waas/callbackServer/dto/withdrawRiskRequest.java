package com.waas.callbackServer.dto;

public class withdrawRiskRequest extends absRequest {

    private withdrawRiskRequestData data;

    public withdrawRiskRequest() {
        this.data = new withdrawRiskRequestData();
    }

    @Override
    public withdrawRiskRequestData getData() {
        return data;
    }

    public void setData(withdrawRiskRequestData data) {
        this.data = data;
    }

    public static class withdrawRiskRequestData {
        private String amount;
        private String coin_symbol;
        private String address;
        private String user_id;
        private String order_id;
        private String timestamp;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCoin_symbol() {
            return coin_symbol;
        }

        public void setCoin_symbol(String coin_symbol) {
            this.coin_symbol = coin_symbol;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
    }
}
