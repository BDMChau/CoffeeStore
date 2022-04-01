package com.coffeestore.query.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OrderDetailDTO {

   Long order_id;

   Long order_detail_id;
   int product_quantity;

   Long product_id;
   String product_name;
   BigDecimal price;

   String prImg_url;

   public OrderDetailDTO(Long order_id, Long order_detail_id, int product_quantity, Long product_id, String product_name, BigDecimal price, String prImg_url) {
      this.order_id = order_id;
      this.order_detail_id = order_detail_id;
      this.product_quantity = product_quantity;
      this.product_id = product_id;
      this.product_name = product_name;
      this.price = price;
      this.prImg_url = prImg_url;
   }
}
