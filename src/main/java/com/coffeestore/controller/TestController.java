package com.coffeestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @RequestMapping("/home")
    public String home() {
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
        public String cart () {
            return "home";
        }

        @RequestMapping("/admin")
        public String adminPage () {
            return "admin";
        }


    }
