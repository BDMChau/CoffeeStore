package com.coffeestore.controller;

import com.coffeestore.query.dto.OrderDto;
import com.coffeestore.service.order.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/get_user_orders/{page}")
    public String getUserOrders(HttpSession session, @PathVariable int page, Model model) {
        String userEmail = (String) session.getAttribute("user_email");
        if (page <= 0) {
            model.addAttribute("err", "something wrong!");

        } else page -= 1;
        int from = page * 10;
        int amount = 10;

        List<OrderDto> orderDtoList = orderService.getUserOrders(userEmail, from, amount);
        if (!orderDtoList.isEmpty()) {
            model.addAttribute("user_orders", orderDtoList);
        }
        return "product";

    }
}
