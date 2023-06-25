package com.waas.client.dto;

public class addressVerifyAddressRequest extends baseRequest {

    /**
     * address
     */
    private String address;

    /**
     * Main chain coin name within 12 characters, the coin name provided by the platform shall prevail
     */
    private String coin;

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
}
