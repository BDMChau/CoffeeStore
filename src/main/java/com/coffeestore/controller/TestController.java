package com.coffeestore.controller;

import com.coffeestore.model.user.User;
import com.coffeestore.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        User user = null;
        if(request.getUserPrincipal() != null) {
            String email = request.getUserPrincipal().getName();
            user = userService.getUserByEmail(email);
        }
        if(user == null) return "home";

        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getId());
        session.setAttribute("email", user.getEmail());

        return "home";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }




    @RequestMapping("/cart")
    public String cart() {
        return "home";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/user-info")
    public String userInfoPage() {
        return "user/user_info";
    }


    @RequestMapping("/paywithvnpay")
    public String payWithVnpay() {
        return "payment/vnpay/index";
    }




}
