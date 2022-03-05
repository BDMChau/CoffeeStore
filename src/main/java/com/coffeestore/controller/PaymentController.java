package com.coffeestore.controller;

import com.coffeestore.api.VNPAY.VNPAY_transaction;
import com.coffeestore.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    VNPAY_transaction vnpay_transaction;

    @GetMapping("/paywithvnpay")
    public String payWithVNPay(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.err.println("acascac");
        String paymentUrl = vnpay_transaction.postToVNPAY(request, response);
        return "redirect:" + paymentUrl;
    }
}
