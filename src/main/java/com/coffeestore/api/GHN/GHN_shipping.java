package com.coffeestore.api.GHN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;


@Service
public class GHN_shipping {
    private static final String token = "28014046-9c3d-11ec-913f-a2241d5a8154";
    private static final String baseUrl = "https://online-gateway.ghn.vn/shiip/public-api";

    @Autowired
    RestTemplate restTemplate;


    public Map getCities() {
        String url = baseUrl + "/master-data/province";
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity res = restTemplate.exchange(url, HttpMethod.GET, request, Map.class, 1);
        if (res.getStatusCode() == HttpStatus.OK) {
            return (Map) res.getBody();
        }

        return new HashMap();
    }

    public Map getDistricts(int provinceId) {
        String url = baseUrl + "/master-data/district";
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);

        Map<String, Object> params = new HashMap<>();
        params.put("province_id", provinceId);

        String queryParam = "province_id={province_id}";
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).query(queryParam).buildAndExpand(params);

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity res = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, Map.class, params);
        if (res.getStatusCode() == HttpStatus.OK) {
            return (Map) res.getBody();
        }

        return new HashMap();
    }


    public Map getwards(int districtId) {
        String url = baseUrl + "/master-data/ward";
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);

        Map<String, Object> params = new HashMap<>();
        params.put("district_id", districtId);

        String queryParam = "district_id={district_id}";
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).query(queryParam).buildAndExpand(params);

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity res = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request, Map.class, params);
        if (res.getStatusCode() == HttpStatus.OK) {
            return (Map) res.getBody();
        }

        return new HashMap();
    }


    public Map getServicess(int toDistrictId) {
        String url = baseUrl + "/v2/shipping-order/available-services";
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);

        Map<String, Object> params = new HashMap<>();
        params.put("shop_id", 2556292); // ID at https://khachhang.ghn.vn/store
        params.put("from_district", 1461); // Gò Vấp tphcm
        params.put("to_district", toDistrictId);

        String queryParam = "shop_id={shop_id}&from_district={from_district}&to_district={to_district}";

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).query(queryParam).buildAndExpand(params);

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity res = restTemplate.exchange(url, HttpMethod.GET, request, Map.class, params);
        if (res.getStatusCode() == HttpStatus.OK) {
            return (Map) res.getBody();
        }

        return new HashMap();
    }

    public Map getShippingFee(int serviceId, int toDistrictId, int toWardId) {
        String url = baseUrl + "/v2/shipping-order/fee";
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);
        headers.set("shop_id", "2556292");

        Map<String, Object> params = new HashMap<>();
        params.put("service_id", serviceId); // ID at https://khachhang.ghn.vn/store
        params.put("insurance_value", 500000); // Gò Vấp tphcm
        params.put("coupon", null);
        params.put("from_district_id", 1461); // Gò Vấp tphcm
        params.put("to_district_id", toDistrictId);
        params.put("to_ward_code", toWardId);
        params.put("height", 30);
        params.put("length", 30);
        params.put("width", 20);
        params.put("weight", 2000);


        HttpEntity request = new HttpEntity(headers);
        ResponseEntity res = restTemplate.exchange(url, HttpMethod.GET, request, Map.class, params);
        if (res.getStatusCode() == HttpStatus.OK) {
            return (Map) res.getBody();

//            "data": {
//                "total": 47000,
//                        "service_fee": 47000,
//                        "insurance_fee": 0,
//                        "pick_station_fee": 0,
//                        "coupon_value": 0,
//                        "r2s_fee": 0
//            }
        }

        return new HashMap();
    }
}
