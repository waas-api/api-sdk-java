package com.waas.client.dto;

public class addressSyncStatusRequest extends baseRequest {

    /**
     * address, within 128 characters
     */
    private String address;

    /**
     * Within 12 characters, the main chain currency of the address (if bnb_bsc, please pass eth)
     */
    private String coin;

    /**
     * string within 40, user UID assigned by address
     */
    private String user_id;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
