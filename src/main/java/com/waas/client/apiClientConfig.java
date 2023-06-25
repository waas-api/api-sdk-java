package com.waas.client;

public class apiClientConfig {

    // required, provided by platform
    String appid;

    // required, default: 1.0
    String version;

    // required, default: admin
    String keyVersion;

    // required, RSA private key value for generate request signature. Create RSA key pair options，length=2048，format=PKCS#8
    String privateKey;

    // required, RSA public key value for verify API response，provided by platform
    String platformPublicKey;

    // required, provided by platform
    String baseUrl;


    public apiClientConfig(String appid, String version, String keyVersion, String privateKey, String platformPublicKey, String baseUrl) {
        this.appid = appid;
        this.version = version;
        this.keyVersion = keyVersion;
        this.privateKey = privateKey;
        this.platformPublicKey = platformPublicKey;
        this.baseUrl = baseUrl;
    }
}
