package com.waas.callbackServer.dto;


public class depositRequest extends absRequest {

    private depositRequestData data;

    public depositRequestData getData() {
        return data;
    }

    public void setData(depositRequestData data) {
        this.data = data;
    }

    public static class depositRequestData {
        private String address;
        private String amount;
        private String chain;
        private String coin;
        private String fee;
        private String from_address;
        private String order_id;
        private String total;
        private String txid;
        private long time;
        private int status;
        private int confirm_count;
        private int type;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getChain() {
            return chain;
        }

        public void setChain(String chain) {
            this.chain = chain;
        }

        public String getCoin() {
            return coin;
        }

        public void setCoin(String coin) {
            this.coin = coin;
        }

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }

        public String getFrom_address() {
            return from_address;
        }

        public void setFrom_address(String from_address) {
            this.from_address = from_address;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getTxid() {
            return txid;
        }

        public void setTxid(String txid) {
            this.txid = txid;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getConfirm_count() {
            return confirm_count;
        }

        public void setConfirm_count(int confirm_count) {
            this.confirm_count = confirm_count;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
