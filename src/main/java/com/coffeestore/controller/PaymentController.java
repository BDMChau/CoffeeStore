package com.coffeestore.controller;

import com.coffeestore.api.GHN.GHN_shipping;
import com.coffeestore.api.VNPAY.VNPAY_transaction;
import com.coffeestore.model.user.User;
import com.coffeestore.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    VNPAY_transaction vnpay_transaction;

    @Autowired
    GHN_shipping ghn_shipping;

    @Autowired
    UserService userService;

    ///////// VNPAY
    @GetMapping("/pay_with_vnpay")
    public String payWithVNPay(HttpServletRequest request) throws Exception {

        return "redirect:" + request.getParameter("paymentUrl");
    }

    @PostMapping("/pay_with_vnpay")
    public ResponseEntity payWithVNPay(@RequestBody Map data, HttpServletRequest request) throws Exception {
        String userEmail = request.getUserPrincipal().getName();
        User user = userService.getUserInfo(userEmail);

        // lưu order
        Long orderId = userService.saveOrderVnPay(user, data);


        String paymentUrl = vnpay_transaction.postToVNPAY(data, user, orderId, request);

        Map<String, Object> msg = Map.of(
           "msg", "set default address OK!",
           "paymentUrl", paymentUrl
        );
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PostMapping("/pay_with_cod")
    public String payWithCode(@RequestBody Map data, HttpServletRequest request, HttpServletResponse response) throws Exception {


        return "redirect:";
    }

    @GetMapping("/url_redirect_vnpay")
    public String urlRedirectVnPay(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Long orderId = Long.parseLong(request.getParameter("vnp_OrderInfo"));

        userService.updateOrder(orderId);

        return "redirect:/user/user-info";
    }


}
