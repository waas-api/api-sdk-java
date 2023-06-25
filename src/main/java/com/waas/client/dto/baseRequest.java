package com.waas.client.dto;

public class baseRequest implements iRequest {
    private String app_id;
    private String version;
    private String key_version;
    private String time;
    private String sign;

    public String getApp_id() {
        return app_id;
    }

    @Override
    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    public String getKey_version() {
        return key_version;
    }

    @Override
    public void setKey_version(String key_version) {
        this.key_version = key_version;
    }

    public String getTime() {
        return time;
    }

    @Override
    public void setTime(String time) {
        this.time = time;
    }

    public String getSign() {
        return sign;
    }

    @Override
    public void setSign(String sign) {
        this.sign = sign;
    }
}