package com.coffeestore.controller;

import com.coffeestore.query.dto.ProductDto;
import com.coffeestore.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{product_id}") // detail a product
    public String getProduct(@PathVariable String product_id, Model model) {

        Long productId = 0L;
        if (!product_id.equals("")) {
            productId = Long.parseLong(product_id);
        }

        ProductDto productDto = productService.getProduct(productId);
        model.addAttribute("product_info", productDto);
        return "product";
    }

    @GetMapping("/top_products/{req}") // products of id
    public String GetProductsOfBrand(@PathVariable int req, @RequestParam int page, Model model) {

        if (page <= 0) {
            model.addAttribute("err", "something wrong!");

        } else page -= 1;
        int from = page * 10;
        int amount = 10;

        List<ProductDto> productDtoList = productService.getTopProducts(req, from, amount);
        productDtoList.forEach(System.err::println);
        model.addAttribute("list_top_products", productDtoList);
        return "brandproducts";
    }


}
