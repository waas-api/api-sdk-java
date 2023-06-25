package com.waas.client.dto;

public class coinListRequest extends baseRequest {

    /**
     * coin name (eg: eth)
     */
    private String coin;

    /**
     * Main chain name (query main chain and its tokens, such as: eth)
     */
    private String chain;

    /**
     * 1<= N <=Max, N>Max ? N=Max ; N<1 ? N=1
     */
    private int page;

    /**
     * number of pages per page (20 ~ 500), default 20
     */
    private int page_size;

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }
}
