package com.coffeestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @RequestMapping("/home")
    public String home(HttpServletRequest request) {
        String name = request.getUserPrincipal().getName();
        System.err.println(name);
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

    @RequestMapping("/products")
    public String product() {
        return "products";
    }


    @RequestMapping("/user/cart")
    public String cart() {
        return "home";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }


}
