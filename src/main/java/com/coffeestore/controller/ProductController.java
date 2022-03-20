package com.coffeestore.controller;

import com.coffeestore.model.product.Product;
import com.coffeestore.query.dto.ProductDto;
import com.coffeestore.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @GetMapping("/update_view/{id}")
    public String updateViewProduct(@PathVariable String id, Model model) {

        Long productId = 0L;
        if (!id.equals("")) {
            productId = Long.parseLong(id);
        }
        Product product = productService.updateViewProduct(productId);
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("get_related_products/{page}")
    public String getRelatedProducts(@PathVariable int page, @RequestParam String category_id, Model model) {

        if (page <= 0) {
            model.addAttribute("err", "something wrong!");

        } else page -= 1;
        int from = page * 10;
        int amount = 10;

        Long categoryId = 0L;
        if (!category_id.equals("")) {
            categoryId = Long.parseLong(category_id);
        }
        List<ProductDto> product = productService.getRelatedProducts(categoryId, from, amount);
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/rating_product")
    public String addRatingProduct(HttpSession httpSession, Model model, @RequestParam String product_id, @RequestParam float value) {
        String userEmail = (String) httpSession.getAttribute("user_email");
        Long productId = 0L;
        if (!product_id.equals("")) {
            productId = Long.parseLong(product_id);
        }

        Product product = productService.addRatingProduct(userEmail, productId, value);
        model.addAttribute("product", product);
        return "product";
    }

//    @PostMapping("/update_ra")
//    public String Product(@RequestParam String product_id) {
//
//        Long productId = Long.parseLong(product_id);
//        Product product = productService.updateViewProduct(productId);
//        return "Update view successfully!";
//    }
//
//    @PostMapping("/update_count_purchased")
//    public String addViewProduct(@RequestParam String product_id) {
//
//        Long productId = Long.parseLong(product_id);
//        Product product = productService.updateViewProduct(productId);
//        return "Update view successfully!";
//    }


}
