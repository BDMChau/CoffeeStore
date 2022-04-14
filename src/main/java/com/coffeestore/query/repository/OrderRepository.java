package com.coffeestore.query.repository;


import com.coffeestore.model.order.Orders;
import com.coffeestore.query.dto.OrderDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT new com.coffeestore.query.dto.OrderDto("+
           " orders.id, orders.created_at, orders.total_bill) " +
           "FROM Orders orders " +
           "JOIN User u ON u.id = orders.user.id " +
           "WHERE u.email =?1 " +
           "ORDER BY orders.created_at DESC ")
    List<OrderDto> getUserOrders(String userEmail, Pageable pageable);

    @Query("select count(o) from Orders o where o.email = ?1")
    Optional<Long> countTotalOrdersByEmail(String userEmail);

    @Query("select o from Orders o where o.created_at = ?1")
    Optional<Orders> findByCreated_at(Calendar time);
}
