package com.coffeestore.query.repository;


import com.coffeestore.model.order.Orders;
import com.coffeestore.query.dto.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT new com.coffeestore.query.dto.OrderDto("+
           " orders.id, orders.created_at, orders.total_bill " +
           ", ord.id, ord.product_quantity " +
           ", pr.id, pr.name, pr.price) " +
           "FROM Orders orders " +
           "JOIN User u ON u.id = orders.user.id " +
           "LEFT JOIN OrderDetail ord ON ord.Orders.id = orders.id " +
           "LEFT JOIN Product pr ON pr.id = ord.product.id " +
           "WHERE u.email = (:user_email) " +
           "ORDER BY orders.created_at")
    List<OrderDto> getUserOrders(Pageable pageable, @Param("user_email") String user_email);

}