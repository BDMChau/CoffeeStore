package com.coffeestore.controller;

import com.coffeestore.model.user.User;
import com.coffeestore.service.auth.SecurityService;
import com.coffeestore.service.user.UserService;
import com.coffeestore.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    //////// login ////////
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) model.addAttribute("errorMsg", "Your email or/and password is invalid!");
        if (logout != null) model.addAttribute("msg", "Logged out!");

        if(error == null || logout == null) return "redirect:home";

        return "auth/login";
    }


    //////// register ////////
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userForm", new User());

        return "auth/register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }

        userService.register(userForm);

        securityService.autoLogin(userForm.getEmail(), userForm.getPasswordConfirm());

        return "auth/login";
    }
}
