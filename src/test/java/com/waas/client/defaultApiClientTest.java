package com.waas.client;


import com.google.gson.GsonBuilder;
import com.waas.client.dto.*;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class defaultApiClientTest {

    private apiClientConfig config = new apiClientConfig(
            "asdfau9imt86qky9",
            "1.0",
            "admin",
            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCY7RWlhM51ArHrQIuWd1tqABES34/3gqSegp+PW1nu7lL0w9z/+dB3GZP243LO54v2K/QHrDHuEEPcVD4WhaTtrho55YRkXFKQNCmE3W/pKZYnU+BOEBEF7wZBt3X+82xNafKvHscfNl1my2to+P74nLGE6kQNZrA+0RGxib9k9JxV1TsNVxLYSlf4TJ4Ikb82qtXMxEXDaEC7mFNtoefJJShw+BMwqmRfOhDP8LG4+10/Kx2ZT0lxyHdF/NyWOazzDzcwxT6HzzzhsP2yNW9tLdlk+SnMVsZEqOBNKzraYCRBhsis0+zmWejQQ5Q3Nu3CHg088+WLci+9ee7G3zLzAgMBAAECggEAQCtb5fRwXZEf70NKT30OEtCsWWsOEiHzyb+uDI2ckzHWBXcaiR7eZtuIxxRx3Hg0truCzqVm3ipdD1saIoE5z7I6twikISjMTE5XDbWNfB1DMIV1ncwIGKFP0suU68JhM6q9dtZHX8WEM9ov3AB/nPrDUq6ql6T7V6CK+CCA+28zDG6Bh8jgGMCGyPtvi7ku09pJUGLwRBfRGE2wpcZ4nvSLwbv9Eyaf2ZIyZw6MH6lFIyI9uVY5ePWh/vVQdbXFmSH2GAuxzxz3T9IvMwUyXiK4t7hVWHJlf9/UQpfbFTXc4V+/Tmn1gQuLmL4oTs1bRg28AhIsunc9yxlr3wfmAQKBgQDHLm4LG+VUIgGJhxR6+KmhXJ3S84PdNhEbnNmRJd2ZQlH38YAjndf2FLTH9KoyWw/hfJp3GTHv716W+T1uqBUhUw7ELugzNY0scxG0xBt+9hJAku+MwgXx53ZnDfV6iRKbc8x/RNRs+OQi8nCaPO3pdKNrMOHtohuYp0+jDAhiMwKBgQDEjMiBPvw6ZWa2Jm2Q9FhSwUc86ZiT+o3MAyoQtIFVXWhCM4I5Yk5JzDIi05iJb/dtyulp9UK+/HIKaJtj2Shsp5CZMW9UISeaklrtk/xS0A4qUUOxNxOFNzQl466RULxLCR0kmLqJ6ou8hHpOkdvlGqRbE5JVVOCMakoa8iysQQKBgBT5QaMv080xK4JE1BZC2vHf48qT093WVKTYtlw/ZX8+6Yy3RGv7sgL6mTK5A7b7ucdfrJA/+e8vAIHbSum9D0SMD3D/E3pY+D2m/EVRpSeQV8mu70SeJawcWG5vnNrDVk9COVVpdQjoiHVZnBvRsKe1nYOrCQ9R06AWdh9QJA3bAoGBAIvjd0Elxvb4/KVfrFOi1MnxbfZYe5O2m/07s1C4Z+SN2opjhqe44+d6QaSv3LzUx9GIvaAAQ0US/0eRNCdYg4DxseSWXpoODtXgnH7C+K8oDSzpMbiLboU9yQu+hJxATgNJtUg6u2k1WccOss4A2fSxhZCc2WWKR1covx12h30BAoGBALZ8IpYY5IJuFXM0aYg5QbOLlDG0Z13bIpKmgk5IHq53uEkR2+ttSN7i2W3fJhlpUpr4HFXEP5Uk3Q7KE4DeziVkAkNnZ4c8TISG2SANqaSZggQWXnZNu3am7P/C/19EHOGJigM/wsbjw5KXMqMYny5QBi2nWF73omosGLjTrSZ2",
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0NwyEfQupjAtS7zIeMuR995t5fzW9FRm9i3+WKQlfLf81wb2dxUyZh2kalCZkkXHbJyyv2XDhMidf1l3kZo/gCXS+RHmsfinCRE6Y4rkFPLhYvq0tGhkoVDFVhPHZGdRkaUBRWlj8pN/BuyMYLMYuGrYAQb2J/c4UG0nCB/VuqQ+WsQoNMHxIU/HGehsShHI99maezheP0F6QNIPUtxeGDKQ52Ks1dWwtIq433MiwRDWaGfRXMVzK+D99BET09e41lJVqvNijhRHwXo6bxjVkJRYmCGShTkYITeDVhd6NpV/mhPrRSQcwEXjJSObHcbh9UhIZjZGAw56Qfqz66wklwIDAQAB",
            "http://api.xxx.com/shopapi");

    @Test
    public void coinList() {
        coinListRequest req = new coinListRequest();
        req.setChain("trx");
        req.setCoin("usdt_trc20");
        try {
            iApiClient c = new defaultApiClient(this.config);
            // get shop support coins
            coinListResponse resp = c.coinList(req);
            System.out.println(new GsonBuilder().create().toJson(resp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addressGetBatch() {
        addressGetBatchRequest req = new addressGetBatchRequest();
        req.setCoin("trx");
        try {
            iApiClient c = new defaultApiClient(this.config);
            addressGetBatchResponse resp = c.addressGetBatch(req);
            System.out.println(new GsonBuilder().create().toJson(resp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addressSyncStatus() {
        addressSyncStatusRequest req = new addressSyncStatusRequest();
        req.setAddress("TSfLouUAVKodmkZ34rNohF3CdJDe1tGaNa");
        req.setCoin("trx");
        req.setUser_id("666");
        try {
            iApiClient c = new defaultApiClient(this.config);
            addressSyncStatusResponse resp = c.addressSyncStatus(req);
            System.out.println(new GsonBuilder().create().toJson(resp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addressList() {
        addressListRequest req = new addressListRequest();
        req.setAddress("TSfLouUAVKodmkZ34rNohF3CdJDe1tGaNa");
        req.setCoin("trx");
        try {
            iApiClient c = new defaultApiClient(this.config);
            addressListResponse resp = c.addressList(req);
            System.out.println(new GsonBuilder().create().toJson(resp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addressVerifyAddress() {
        addressVerifyAddressRequest req = new addressVerifyAddressRequest();
        req.setAddress("TYce1naETt8kqwWHH3dBvi6S1yaCvJmp84");
        req.setCoin("trx");
        try {
            iApiClient c = new defaultApiClient(this.config);
            addressVerifyAddressResponse resp = c.addressVerifyAddress(req);
            System.out.println(new GsonBuilder().create().toJson(resp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void transfer() {
        transferRequest req = new transferRequest();
        req.setAddress("TR8HJHjNUN4mvbRZ1BfircAfHEXDHhfvNb");
        req.setCoin("trx");
        req.setUser_id("10001");
        req.setAmount("1");
        req.setTrade_id(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        try {
            iApiClient c = new defaultApiClient(this.config);
            transferResponse resp = c.transfer(req);
            System.out.println(new GsonBuilder().create().toJson(resp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}