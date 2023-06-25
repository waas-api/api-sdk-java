package com.waas.client.dto;

public class transferRequest extends baseRequest {

    /**
     * The unique ID of the merchant's transaction (recommended format: year, month, day, hour, minute, second + 6-digit random number case: 20200311202903000001)
     */
    private String trade_id;

    /**
     * currency abbreviation - platform agreement shall prevail
     */
    private String coin;

    /**
     * payment address, an error will occur if it exceeds the range
     */
    private String address;

    /**
     * withdrawal amount, an error will occur if it exceeds the range
     */
    private String amount;

    /**
     * user ID, out of range error
     */
    private String user_id;

    /**
     * memo/tag needs to be filled in when the current currency is eos and its tokens
     */
    private String memo;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(String trade_id) {
        this.trade_id = trade_id;
    }
}
