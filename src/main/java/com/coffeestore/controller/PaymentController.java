package com.coffeestore.controller;

import com.coffeestore.api.GHN.GHN_shipping;
import com.coffeestore.api.VNPAY.VNPAY_transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    VNPAY_transaction vnpay_transaction;

    @Autowired
    GHN_shipping ghn_shipping;


    ///////// VNPAY
    @GetMapping("/pay_with_vnpay")
    public String payWithVNPay(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String paymentUrl = vnpay_transaction.postToVNPAY(request, response);
        return "redirect:" + paymentUrl;
    }

    @GetMapping("/url_redirect_vnpay")
    public String urlRedirectVnPay(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("vnp_Amount", String.valueOf(Integer.parseInt(request.getParameter("vnp_Amount")) / 100));

        return "payment/vnpay/vnpay_return";
    }


}
