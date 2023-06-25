package com.waas.client.dto;

public class addressListRequest extends baseRequest {

    /**
     * address
     */
    private String address;

    /**
     * main chain coin name - see the description of the public information of supported coins (if bnb_bsc please use eth)
     */
    private String coin;

    /**
     * 1<= N <=Max, if it exceeds Max, take Max, if it is less than 1, return 1
     */
    private int page;

    /**
     * 1=used, 2=not used
     */
    private int is_used;

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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getIs_used() {
        return is_used;
    }

    public void setIs_used(int is_used) {
        this.is_used = is_used;
    }
}
