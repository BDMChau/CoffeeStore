package com.coffeestore.controller;

import com.coffeestore.model.user.User;
import com.coffeestore.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/cart")
    public String cart() {
        return "home";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/user-info")
    public String getUserInfo(Model model, HttpServletRequest request) {
        String userEmail = request.getUserPrincipal().getName();
        User user = userService.getUserInfo(userEmail);

        model.addAttribute("user", user);
        model.addAttribute("userForm", new User());

        return "user/user_info";
    }

    @PostMapping("/user-info")
    public String updateUserInfo(Model model, @ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userService.updateProfile(userForm);

        return "user/user_info";
    }


}
