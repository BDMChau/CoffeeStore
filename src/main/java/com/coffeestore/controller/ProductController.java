package com.coffeestore.controller;

import com.coffeestore.query.dto.ProductDto;
import com.coffeestore.service.product.ProductService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{product_id}")
    public ProductDto getProduct(@PathVariable String product_id) {

        Long productId = 0L;
        if (!product_id.equals("")) {
            productId = Long.parseLong(product_id);
        }

        return productService.getProduct(productId);
    }
}
