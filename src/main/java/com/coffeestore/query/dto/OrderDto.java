package com.coffeestore.query.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {
    Long order_id;
    Calendar created_at;
    BigDecimal total_bill;


    List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();


    public OrderDto(Long order_id, Calendar created_at, BigDecimal total_bill) {
        this.order_id = order_id;
        this.created_at = created_at;
        this.total_bill = total_bill;

    }

    public OrderDto(Long order_id, Calendar created_at, BigDecimal total_bill, List<OrderDetailDTO> orderDetailDTOS) {
        this.order_id = order_id;
        this.created_at = created_at;
        this.total_bill = total_bill;
        this.orderDetailDTOS = orderDetailDTOS;
    }

}
