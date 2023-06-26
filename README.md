# api-sdk-java
---
api sdk of java

## dependency

```xml

<dependency>
    <groupId>io.github.waas-api</groupId>
    <artifactId>api-sdk-java</artifactId>
    <version>1.0.2</version>
</dependency>
```

## Shop Client Example

```java
public class defaultApiClientTest {

    private apiClientConfig config = new apiClientConfig(
            "asdfau9imt86qky9",
            "1.0",
            "admin",
            "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",
            "http://api.xxx.com/shopapi");

    @Test
    public void coinList() {
        coinListRequest req = new coinListRequest();
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
}
```

> See more example in file `src/test/java/com/waas/client/defaultApiClientTest.java`.

## Callback Server Example

### start a http server

```java
public class serverTest {

    private String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCY7RWlhM51ArHrQIuWd1tqABES34/3gqSegp+PW1nu7lL0w9z/+dB3GZP243LO54v2K/QHrDHuEEPcVD4WhaTtrho55YRkXFKQNCmE3W/pKZYnU+BOEBEF7wZBt3X+82xNafKvHscfNl1my2to+P74nLGE6kQNZrA+0RGxib9k9JxV1TsNVxLYSlf4TJ4Ikb82qtXMxEXDaEC7mFNtoefJJShw+BMwqmRfOhDP8LG4+10/Kx2ZT0lxyHdF/NyWOazzDzcwxT6HzzzhsP2yNW9tLdlk+SnMVsZEqOBNKzraYCRBhsis0+zmWejQQ5Q3Nu3CHg088+WLci+9ee7G3zLzAgMBAAECggEAQCtb5fRwXZEf70NKT30OEtCsWWsOEiHzyb+uDI2ckzHWBXcaiR7eZtuIxxRx3Hg0truCzqVm3ipdD1saIoE5z7I6twikISjMTE5XDbWNfB1DMIV1ncwIGKFP0suU68JhM6q9dtZHX8WEM9ov3AB/nPrDUq6ql6T7V6CK+CCA+28zDG6Bh8jgGMCGyPtvi7ku09pJUGLwRBfRGE2wpcZ4nvSLwbv9Eyaf2ZIyZw6MH6lFIyI9uVY5ePWh/vVQdbXFmSH2GAuxzxz3T9IvMwUyXiK4t7hVWHJlf9/UQpfbFTXc4V+/Tmn1gQuLmL4oTs1bRg28AhIsunc9yxlr3wfmAQKBgQDHLm4LG+VUIgGJhxR6+KmhXJ3S84PdNhEbnNmRJd2ZQlH38YAjndf2FLTH9KoyWw/hfJp3GTHv716W+T1uqBUhUw7ELugzNY0scxG0xBt+9hJAku+MwgXx53ZnDfV6iRKbc8x/RNRs+OQi8nCaPO3pdKNrMOHtohuYp0+jDAhiMwKBgQDEjMiBPvw6ZWa2Jm2Q9FhSwUc86ZiT+o3MAyoQtIFVXWhCM4I5Yk5JzDIi05iJb/dtyulp9UK+/HIKaJtj2Shsp5CZMW9UISeaklrtk/xS0A4qUUOxNxOFNzQl466RULxLCR0kmLqJ6ou8hHpOkdvlGqRbE5JVVOCMakoa8iysQQKBgBT5QaMv080xK4JE1BZC2vHf48qT093WVKTYtlw/ZX8+6Yy3RGv7sgL6mTK5A7b7ucdfrJA/+e8vAIHbSum9D0SMD3D/E3pY+D2m/EVRpSeQV8mu70SeJawcWG5vnNrDVk9COVVpdQjoiHVZnBvRsKe1nYOrCQ9R06AWdh9QJA3bAoGBAIvjd0Elxvb4/KVfrFOi1MnxbfZYe5O2m/07s1C4Z+SN2opjhqe44+d6QaSv3LzUx9GIvaAAQ0US/0eRNCdYg4DxseSWXpoODtXgnH7C+K8oDSzpMbiLboU9yQu+hJxATgNJtUg6u2k1WccOss4A2fSxhZCc2WWKR1covx12h30BAoGBALZ8IpYY5IJuFXM0aYg5QbOLlDG0Z13bIpKmgk5IHq53uEkR2+ttSN7i2W3fJhlpUpr4HFXEP5Uk3Q7KE4DeziVkAkNnZ4c8TISG2SANqaSZggQWXnZNu3am7P/C/19EHOGJigM/wsbjw5KXMqMYny5QBi2nWF73omosGLjTrSZ2";
    private String platformPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0NwyEfQupjAtS7zIeMuR995t5fzW9FRm9i3+WKQlfLf81wb2dxUyZh2kalCZkkXHbJyyv2XDhMidf1l3kZo/gCXS+RHmsfinCRE6Y4rkFPLhYvq0tGhkoVDFVhPHZGdRkaUBRWlj8pN/BuyMYLMYuGrYAQb2J/c4UG0nCB/VuqQ+WsQoNMHxIU/HGehsShHI99maezheP0F6QNIPUtxeGDKQ52Ks1dWwtIq433MiwRDWaGfRXMVzK+D99BET09e41lJVqvNijhRHwXo6bxjVkJRYmCGShTkYITeDVhd6NpV/mhPrRSQcwEXjJSObHcbh9UhIZjZGAw56Qfqz66wklwIDAQAB";

    private String riskPrivateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDP1ZvDgmtRszLys7d933C+Qv+9mC1IiJM45IBqMW9haNcOlxY/rB9ewKBY7pC7njeo1LMQxIzgSaehMdNsTXLfsO2o3pkn7Vzof0kP8W4pKPRarnNoV7qNvRh0Lbwb2bzzwul1kUovHv7MMO6wIQmC3QMWJMz3l8WP5wz7aAnpI9DGzaei4PO8/lyj0vBAGuR0mdIXE5x62I/2j5nHl7pZsuLIia/pOpc7FHK3F288SmICpmiRjz4WLLqCxuKFZW7hEYzzoddf4mxPydXB71T8Y/sN7rifz3hPuavHh6pYbyDvMjO0RJCJ1cPnEE7OgDgrFWAG5suEPL2FTe3ZoJZxAgMBAAECggEAa2Ad2HWSAqTFhrSo8UQ2WGX/ALIVeyrsfPE5EyQ1OitTKHuQiBbiIi786NVgOz5z3Sr+1IPnkJ0dGN/ILmUZG06qiptunz03yfqxAaanVmaNUChfAaKJhF8UujlCvVTSFVI3EYGdxRiLZW1GdAKtikmrJY6fwq9L55vkjiLjM+pZaDzs9ZNoGDKJPvfb2U694B43U6IB3krwZD8wUMi8CP/3MON5hjdIQ820zfk9j8lgx5sWRkRzIhe2cKe8TRC1oPRt2io6Uxv1HnWFDpLQ/1eEkRTVTAEEpAKfgshMyOY2BP0FSDZTssBzAYDdNHqDAyNXFbD6eYQRDMUwhZhGAQKBgQDzqOQPlVUY9uAs9E76XM/uXVwigaqQ6NUxjXXs+tGSnwcu5nk2GlNgYU5IJUgd8/G2fGxn2luPO2G1/X+6Bj6bRGFu+YS8NkE7fuFze6nu2TKe3wunQJldScqSOpELTWiTcDe8FlMqHnGncJ44JxkXEKCgysoInGBE3zyH+k0KoQKBgQDaXDu9fXNQmKhmu1MYveKfD1L7L1R0FKB58glY2GjhHwZW9lwn7W1t6kOroHCIHPKxlKNuWBT7uIs/Agd/Mo+fA6w3mn/oEHzrgsrqabeIMKHIJXiGt1wlfp/fyIdMwAumN9yMGOoLS+oa3DMOfFa/vQpEXVOJsIzUVt/rBtNJ0QKBgBp04C6A/Hh1denrrReqNDmhkXt9sNODNILo5UESCudstQ72n3qsaRkx95oF0krOThSOdgbgwshOnlFwcQn1255oUlwGY8875OFc6YXsi4sPsltlxJIohX6HoKM4EL+1bAF2UdbuZaFRJO4VYFighizm9UoAOuescxeHVb8+AleBAoGBAKWoKW5FWRGA7ukZHh58GAwhvQtwybpS17gL5glwDIkVV2Lr/dgQqN8lRXdT/WtVwszz/dS9oBWj2IfRi0x1WD4DtEhuvrCYqZymGjkiQKlic6n6u2hAfPi5CqLkZ7jTTUMpx/jFAfHWAuGjwlwv+kP2L27T+odP2FdTHQcZo3uxAoGAT1HFdzSQLpPAtJyhPqffnhks+XHdsmGic35CAQyyiEUIz4MoxKwnodWu1hDfpdPexcAhbwWSW04TtKXC5eur+H1E7F2KcMJ2IeTzFB691bzeseSrG6QIkKOFC/hSI5ac+lem98Pc3i3MRDx3xRvBsAy4uAWdzJAA70TWEOsVIUw=";
    private String riskPlatformPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6YDzI7HOT14i2xWsSfBjZQKGt3zzMU7UDFNkYwa539wFM6FRnkFd6HcTjqCWehivLTbQSbV1wTd9Ub7zXSEEC0OKcCqHCYXdWYW48jAwtvRKUjGJ0PKxxZS2XUUWpubbQAXLRUx7DmtbCyDDe+cwlKxGI5P6ppSSNGmRpbOztSAyUsL1njv5zw2u91LRo6stM06FCV3x+kJsWYmcs0kzchAt89QwfiUK5G6T8myIyFHEKozsiU2brGd5XvxpdX4jJ5RAP0jGUr3i1n7p4dT2SRFL0WENHqgkoKaxPwAtTSg7j4YotMXfSvkNk7CJXYvq63GTX1UWL72OsmtKdvkYDwIDAQAB";

    @Test
    public void serve() {

        serverTool st = new serverTool(platformPublicKey, privateKey);
        serverTool riskTool = new serverTool(riskPlatformPublicKey, riskPrivateKey);

        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

            httpServer.createContext("/callback/deposit", new depositHandler(st));
            httpServer.createContext("/callback/withdraw", new withdrawHandler(st));
            httpServer.createContext("/callback/withdraw/risk", new withdrawRiskHandler(riskTool));

            httpServer.setExecutor(Executors.newFixedThreadPool(10));
            httpServer.start();
            System.out.println(httpServer.getAddress());
            Thread.sleep(1800 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### implements a HttpHandler

```java
public class depositHandler implements HttpHandler {

    private serverTool sTool;

    public depositHandler(serverTool tool) {
        this.sTool = tool;
    }

    @Override
    public void handle(HttpExchange httpExchange) {

        Gson gson = new GsonBuilder().create();
        depositResponse res = new depositResponse();

        try {

            // get request object
            depositRequest req = this.sTool.getDepositRequest(new InputStreamReader(httpExchange.getRequestBody()));
            System.out.println(gson.toJson(req));


            // verify request sign
            if (!this.sTool.verifySign(req)) {
                res.setStatus(500);
                this.sTool.writeResponse(httpExchange, res);
                return;
            }

            // TODO check info according to your needs

            // return success after all check is OK
            res.setStatus(200);
            res.getData().setSuccess_data("success");

            // gen sign and set to response object
            this.sTool.addSignToResponse(res);
            System.out.println(gson.toJson(res));

            this.sTool.writeResponse(httpExchange, res);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
```

> See more example in file `src/test/java/com/waas/callbackServer/serverTest.java`.
