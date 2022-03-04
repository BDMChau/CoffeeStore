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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final String regexEmail = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
    private final String regexPass = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"; //passwordLength8Number1

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


        return "auth/login";
    }


//    @PostMapping("/login")
//    public String login(String error, String logout) {
//        System.err.println("AAAAAAAAAAAA");
//        System.err.println("AAAAAAAAAAAA");
//        System.err.println("AAAAAAAAAAAA");
//
//
//        return "auth/login";
//    }


    //////// register ////////
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userForm", new User());

        return "auth/register";
    }

    @PostMapping("/register")
    public String registration(Model model, @ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        if (userForm.getName().isEmpty() || userForm.getPassword().isEmpty() || userForm.getPasswordConfirm().isEmpty() || userForm.getEmail().isEmpty()) {
            model.addAttribute("errMsg", "Fill all fields!");
            return "auth/register";
        }

        if (!Pattern.matches(regexEmail, userForm.getEmail())){
            model.addAttribute("errMsg", "Wrong email format!");
            return "auth/register";
        }

        if (!Pattern.matches(regexPass, userForm.getPassword())) {
            model.addAttribute("errMsg", "Not strong enough, password must be length 8 , at least 1 letter and 1 number!");
            return "auth/register";
        }

        if (!userForm.getPasswordConfirm().equals(userForm.getPassword())) {
            model.addAttribute("errMsg", "Password is not match!");
            return "auth/register";
        }


        boolean isCreated = userService.register(userForm);
        if(!isCreated) {
            model.addAttribute("errMsg", "Email is existed!");
            return "auth/register";
        }

//        securityService.autoLogin(userForm.getEmail(), userForm.getPasswordConfirm());

        model.addAttribute("msg", "Register successfully!");
        return "auth/register";
    }


}
