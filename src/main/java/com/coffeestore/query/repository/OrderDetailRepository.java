package com.coffeestore.query.repository;

import com.coffeestore.model.order.OrderDetail;
import com.coffeestore.query.dto.OrderDetailDTO;
import com.coffeestore.query.dto.OrderDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

   @Query("SELECT new com.coffeestore.query.dto.OrderDetailDTO(" +
          " orders.id, ord.id, ord.product_quantity, pr.id, pr.name, pr.price, pri.image_url) " +
          "FROM Orders orders " +
          "LEFT JOIN OrderDetail ord ON orders.id = ord.Orders.id " +
          "LEFT JOIN Product pr ON pr.id = ord.product.id " +
          "LEFT JOIN ProductImage pri ON pr.id = pri.product.id " +
          "WHERE orders.id = ?1 "+
          "ORDER BY orders.created_at")
   List<OrderDetailDTO> getOrderDetailByOrders(Long order_id);
}
