package com.coffeestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AuthController {

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid username or password");
        }

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMsg = null;
        if(error != null) {
            System.err.println(error);
            errorMsg = "Username or password is incorrect!";
            return "login";
        }
        if(logout != null) {
            errorMsg = "Logged out!";
        }

        model.addAttribute("errorMsg", errorMsg);
        return "home";
    }

    @RequestMapping("/register")
    public String register () {
        return "register";
    }


}
