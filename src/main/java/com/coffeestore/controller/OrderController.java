package com.coffeestore.controller;

import com.coffeestore.query.dto.OrderDto;
import com.coffeestore.service.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

   private final OrderService orderService;

   public OrderController(OrderService orderService) {
      this.orderService = orderService;
   }

   @GetMapping("/get_user_orders/{page}")
   public ResponseEntity getUserOrders(HttpServletRequest request, @PathVariable int page) {
      String userEmail = request.getUserPrincipal().getName();

      page = page - 1;
      int from = page * 3;
      int amount = 3;

      System.err.println("email: " + userEmail);
      System.err.println("from: " + from);
      System.err.println("amount: " + amount);

      List<OrderDto> orderDtoList = orderService.getUserOrders(userEmail, from, amount);
      if (orderDtoList.isEmpty()) {
         Map<String, Object> err = Map.of(
            "err", "Something wrong!"
         );
         return new ResponseEntity<>(err, HttpStatus.OK);
      }
      Map<String, Object> msg = Map.of(
         "msg", "get user orders successfully!",
         "user_orders", orderDtoList
      );
      return new ResponseEntity<>(msg, HttpStatus.OK);
   }
}
