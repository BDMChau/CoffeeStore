package com.coffeestore.service.order;

import com.coffeestore.helpers.OffsetBasedPageRequest;
import com.coffeestore.query.dto.OrderDetailDTO;
import com.coffeestore.query.dto.OrderDto;
import com.coffeestore.query.repository.OrderDetailRepository;
import com.coffeestore.query.repository.OrderRepository;
import com.coffeestore.query.repository.UserRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderDetailRepository orderDetailRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
       this.orderDetailRepository = orderDetailRepository;
    }

    public List<OrderDto> getUserOrders(String userEmail, int from, int amount){
       Pageable pageable = new OffsetBasedPageRequest(from, amount);
       List<OrderDto> orderDtoList  = orderRepository.getUserOrders(userEmail, pageable);
       if(orderDtoList.isEmpty()){
           return new ArrayList<>();
       }
       orderDtoList.forEach(order ->{
          List<OrderDetailDTO> orderDetailDTOS = orderDetailRepository.getOrderDetailByOrders(order.getOrder_id());
          if(orderDetailDTOS.isEmpty()){
          }
          if(order.getOrder_id().equals(orderDetailDTOS.get(0).getOrder_id())){
             order.setOrderDetailDTOS(orderDetailDTOS);
          }

       });
       return orderDtoList;
    }
}
