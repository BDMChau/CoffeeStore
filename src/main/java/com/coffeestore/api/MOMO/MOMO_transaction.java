package com.coffeestore.api.MOMO;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.TimeZone;


@Service
public class MOMO_transaction {
    private static final String partnerCode = "MOMOEKPV20220305";

    private static final String accessKey_web = "ulzctW8LeSEQOxsh";
    private static final String secretKey_web = "EIyIWT94pRRjO7th855dMUXZFINkCedc"; // create signature with HMAC-SHA256

    private static final String publicKey_mobile = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAiNF8bjcHoEho"; // encode with RSA

    private final String requestId = partnerCode + Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
    private final String orderId = requestId;
    private final String orderInfo = "pay with momo";
    private final String requestType = "captureWallet";
    private final String extraData = ""; //pass empty value if your merchant does not have stores
    private final String amount = "";

}
