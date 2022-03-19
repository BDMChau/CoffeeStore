package com.coffeestore.query.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    Long bra_id;
    String bra_description;
    String bra_logo;
    String bra_name;

    Long cate_id;
    String cate_description;
    String cate_name;

    Long pr_id;
    String pr_description;
    String pr_name;
    BigDecimal pr_price;
    int count_purchased;
    int count_rating;
    int count_views;
    Long rating_star;

    Long prImg_id;
    String prImg_url;

    public ProductDto(Long bra_id, String bra_description, String bra_logo, String bra_name,
                      Long cate_id, String cate_description, String cate_name,
                      Long pr_id, String pr_description, String pr_name, BigDecimal pr_price,
                      int count_purchased, int count_rating, int count_views, Long rating_star,
                      Long prImg_id, String prImg_url) {
        this.bra_id = bra_id;
        this.bra_description = bra_description;
        this.bra_logo = bra_logo;
        this.bra_name = bra_name;
        this.cate_id = cate_id;
        this.cate_description = cate_description;
        this.cate_name = cate_name;
        this.pr_id = pr_id;
        this.pr_description = pr_description;
        this.pr_name = pr_name;
        this.pr_price = pr_price;
        this.count_purchased = count_purchased;
        this.count_rating = count_rating;
        this.count_views = count_views;
        this.rating_star = rating_star;
        this.prImg_id = prImg_id;
        this.prImg_url = prImg_url;
    }

    public ProductDto(Long bra_id, String bra_description, String bra_logo, String bra_name,
                      Long pr_id, String pr_description, String pr_name, BigDecimal pr_price,
                      Long prImg_id, String prImg_url) {
        this.bra_id = bra_id;
        this.bra_description = bra_description;
        this.bra_logo = bra_logo;
        this.bra_name = bra_name;

        this.pr_id = pr_id;
        this.pr_description = pr_description;
        this.pr_name = pr_name;
        this.pr_price = pr_price;

        this.prImg_id = prImg_id;
        this.prImg_url = prImg_url;
    }

    public ProductDto(Long bra_id, Long pr_id, String pr_description, String pr_name, BigDecimal pr_price,
                      Long prImg_id, String prImg_url) {
        this.bra_id = bra_id;
        this.pr_id = pr_id;
        this.pr_description = pr_description;
        this.pr_name = pr_name;
        this.pr_price = pr_price;
        this.prImg_id = prImg_id;
        this.prImg_url = prImg_url;
    }

    public ProductDto(Long bra_id, String bra_logo, String bra_name,
                      Long cate_id, String cate_name,
                      Long pr_id, String pr_description, String pr_name, BigDecimal pr_price,
                      Long prImg_id, String prImg_url) {
        this.bra_id = bra_id;
        this.bra_logo = bra_logo;
        this.bra_name = bra_name;
        this.cate_id = cate_id;
        this.cate_name = cate_name;
        this.pr_id = pr_id;
        this.pr_description = pr_description;
        this.pr_name = pr_name;
        this.pr_price = pr_price;
        this.prImg_id = prImg_id;
        this.prImg_url = prImg_url;
    }
}
