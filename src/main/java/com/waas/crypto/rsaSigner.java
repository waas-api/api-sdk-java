package com.waas.crypto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
import java.util.stream.Collectors;

/**
 * crypto util methods for rsa sign and verify sign
 */
public class rsaSigner {

    private static final Gson gson = new GsonBuilder().create();

    public String genSign(Map<String, String> data, String priKey) throws NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, InvalidKeyException {
        return this.genSign(this.genSignString(data), priKey);
    }

    public String genSign(Object data, String priKey) throws NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, InvalidKeyException {
        return this.genSign(this.genSignString(toStringMap(gson.toJson(data))), priKey);
    }

    public String genSign(String toSignStr, String priKey) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] decodedKey = Base64.getDecoder().decode(priKey.getBytes(StandardCharsets.UTF_8));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
        PrivateKey pk = keyFactory.generatePrivate(keySpec);

        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initSign(pk);
        signature.update(toSignStr.getBytes(StandardCharsets.UTF_8));
        return new String(Base64.getEncoder().encode(signature.sign()), StandardCharsets.UTF_8);
    }

    public String genSignString(Map<String, String> params) {
        if (null == params || params.size() == 0) {
            return "";
        }

        List<String> sortedKeys = new ArrayList<>(params.keySet());
        sortedKeys.remove("sign");
        sortedKeys.sort(null);
        String sb = sortedKeys.stream().map(s -> s + "=" + params.get(s)).collect(Collectors.joining("&"));

        return sb;
    }


    public boolean verifySign(JsonElement data, String sign, String pubKey) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        String signString = this.genSignString(toStringMap(data));

        byte[] keyBytes = Base64.getDecoder().decode(pubKey.getBytes(StandardCharsets.UTF_8));
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey key = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(key);
        signature.update(signString.getBytes(StandardCharsets.UTF_8));
        return signature.verify(Base64.getDecoder().decode(sign.getBytes(StandardCharsets.UTF_8)));
    }

    public static Map<String, String> toStringMap(String str) {
        JsonElement jEle = JsonParser.parseString(str);
        Map<String, String> resMap = new HashMap<>();
        if (null != jEle && jEle.isJsonObject()) {
            for (Map.Entry<String, JsonElement> entry : jEle.getAsJsonObject().entrySet()) {
                resMap.put(entry.getKey(), valueAsString(entry.getValue()));
            }
        }
        return resMap;
    }

    public static Map<String, String> toStringMap(JsonElement data) {
        Map<String, String> resMap = new HashMap<>();
        if (null != data && data.isJsonObject()) {
            for (Map.Entry<String, JsonElement> entry : data.getAsJsonObject().entrySet()) {
                resMap.put(entry.getKey(), valueAsString(entry.getValue()));
            }
        }
        return resMap;
    }

    static String valueAsString(JsonElement element) {
        if (element.isJsonNull()) {
            return "";
        } else if (element.isJsonPrimitive()) {
            return element.getAsJsonPrimitive().getAsString();
        } else if (element.isJsonObject()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, JsonElement> entry : element.getAsJsonObject().entrySet()) {
                sb.append(valueAsString(entry.getValue()));
            }
            return sb.toString();
        } else if (element.isJsonArray()) {
            StringBuilder sb = new StringBuilder();
            for (JsonElement vv : element.getAsJsonArray()) {
                sb.append(valueAsString(vv));
            }
            return sb.toString();
        }
        return "";
    }
}