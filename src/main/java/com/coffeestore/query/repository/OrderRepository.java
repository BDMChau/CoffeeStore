package com.coffeestore.query.repository;


import com.coffeestore.model.order.Orders;
import com.coffeestore.query.dto.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT new com.coffeestore.query.dto.OrderDto("+
           " or.id, or.created_at, or.total_bill " +
           ", ord.id, ord.product_quantity " +
           ", pr.id, pr.name, pr.price) " +
           "FROM Orders or " +
           "JOIN User u ON u.id = or.user.id " +
           "LEFT JOIN OrderDetail ord ON ord.Orders.id = or.id " +
           "LEFT JOIN Product pr ON pr.id = ord.product.id " +
           "WHERE u.email =?1 " +
           "ORDER BY or.created_at")
    List<OrderDto> getUserOrders(Pageable pageable, String user_email);

}
