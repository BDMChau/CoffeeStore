package com.coffeestore.service.order;

import com.coffeestore.helpers.OffsetBasedPageRequest;
import com.coffeestore.query.dto.OrderDto;
import com.coffeestore.query.repository.OrderRepository;
import com.coffeestore.query.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public List<OrderDto> getUserOrders(String userEmail, int from, int amount){
        Pageable pageable = (Pageable) new OffsetBasedPageRequest(from, amount);
       List<OrderDto> orderDtoList = orderRepository.getUserOrders(pageable, userEmail);
       if(orderDtoList.isEmpty()){
           return new ArrayList<>();
       }
       return orderDtoList;
    }
}
