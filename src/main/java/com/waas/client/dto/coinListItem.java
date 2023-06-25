package com.waas.client.dto;

public class coinListItem {
    private String coin;
    private String chain;
    private String status;
    private long open_in;
    private long open_out;
    private String open_address;
    private String confirm_count;
    private String min_transfer_in_amount;
    private String min_transfer_out_amount;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getOpen_in() {
        return open_in;
    }

    public void setOpen_in(long open_in) {
        this.open_in = open_in;
    }

    public long getOpen_out() {
        return open_out;
    }

    public void setOpen_out(long open_out) {
        this.open_out = open_out;
    }

    public String getOpen_address() {
        return open_address;
    }

    public void setOpen_address(String open_address) {
        this.open_address = open_address;
    }

    public String getConfirm_count() {
        return confirm_count;
    }

    public void setConfirm_count(String confirm_count) {
        this.confirm_count = confirm_count;
    }

    public String getMin_transfer_in_amount() {
        return min_transfer_in_amount;
    }

    public void setMin_transfer_in_amount(String min_transfer_in_amount) {
        this.min_transfer_in_amount = min_transfer_in_amount;
    }

    public String getMin_transfer_out_amount() {
        return min_transfer_out_amount;
    }

    public void setMin_transfer_out_amount(String min_transfer_out_amount) {
        this.min_transfer_out_amount = min_transfer_out_amount;
    }
}
