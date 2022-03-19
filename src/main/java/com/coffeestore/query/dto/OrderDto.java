package com.coffeestore.query.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {
    Long order_id;
    Calendar created_at;
    BigDecimal total_bill;

    Long order_detail_id;
    int product_quantity;

    Long product_id;
    String product_name;
    BigDecimal price;

    public OrderDto(Long order_id, Calendar created_at, BigDecimal total_bill,
                    Long order_detail_id, int product_quantity,
                    Long product_id, String product_name, BigDecimal price) {
        this.order_id = order_id;
        this.created_at = created_at;
        this.total_bill = total_bill;
        this.order_detail_id = order_detail_id;
        this.product_quantity = product_quantity;
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
    }
}
