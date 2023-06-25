package com.waas.callbackServer.dto;

public abstract class absResponse implements iResponse {

    protected int status;
    protected String sign;

    @Override
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSign() {
        return sign;
    }

    @Override
    public void setSign(String sign) {
        this.sign = sign;
    }

    public static class successData {
        private String success_data;

        public String getSuccess_data() {
            return success_data;
        }

        public void setSuccess_data(String success_data) {
            this.success_data = success_data;
        }
    }
}
