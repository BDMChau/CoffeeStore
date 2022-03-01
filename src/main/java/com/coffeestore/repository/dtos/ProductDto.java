package com.coffeestore.repository.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    private Long brand_id;
    private String brand_name;

    private Long category_id;
    private String category_name;

    private Long product_id;
    private String description;
    private String name;
    private BigDecimal price;


    public ProductDto(Long brand_id, String brand_name,
                      Long category_id, String category_name,
                      Long product_id, String description, String name, BigDecimal price) {

        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.category_id = category_id;
        this.category_name = category_name;
        this.product_id = product_id;
        this.description = description;
        this.name = name;
        this.price = price;
    }
}
