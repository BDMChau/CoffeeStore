package com.coffeestore.controller;

import com.coffeestore.model.order.OrderDetail;
import com.coffeestore.model.user.User;
import com.coffeestore.query.dto.OrderDto;
import com.coffeestore.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public String getUserInfo(HttpSession session) {
       String userEmail = (String) session.getAttribute("user_email");
        User user = userService.getUserInfo(userEmail);

        return "user/user_info";
    }




}
