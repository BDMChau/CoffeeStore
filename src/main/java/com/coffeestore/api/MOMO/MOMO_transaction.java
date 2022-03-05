package com.coffeestore.api.MOMO;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.TimeZone;


@Service
public class MOMO_transaction {
    private static String partnerCode = "MOMOEKPV20220305";

    private static String accessKey_web = "ulzctW8LeSEQOxsh";
    private static String secretKey_web = "EIyIWT94pRRjO7th855dMUXZFINkCedc"; // create signature with HMAC-SHA256

    private static String publicKey_mobile = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAiNF8bjcHoEho"; // encode with RSA

    private String requestId = partnerCode + Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
    private String orderId = requestId;
    private String orderInfo = "pay with momo";
    private String requestType = "captureWallet";
    private String extraData = ""; //pass empty value if your merchant does not have stores
    private String amount = "";

}
