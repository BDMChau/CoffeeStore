package com.coffeestore.controller;

import com.coffeestore.query.dto.ProductDto;
import com.coffeestore.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{product_id}")
    public String getProduct(@PathVariable String product_id, Model model) {

        Long productId = 0L;
        if (!product_id.equals("")) {
            productId = Long.parseLong(product_id);
        }

        ProductDto productDto = productService.getProduct(productId);
        model.addAttribute("product_info", productDto);
        return "product";
    }
}
