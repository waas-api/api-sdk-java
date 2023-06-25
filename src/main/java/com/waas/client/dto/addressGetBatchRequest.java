package com.waas.client.dto;

public class addressGetBatchRequest extends baseRequest {

    /**
     * main chain coin name within 12 characters, the coin name platform shall prevail (if bnb_bsc please use eth)
     */
    private String coin;

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

}
