package com.coffeestore.controller;

import com.coffeestore.model.product.Product;
import com.coffeestore.query.dto.ProductDto;
import com.coffeestore.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*------ Product page --------*/
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



    @PostMapping("/get-products") // detail a product
    public ResponseEntity getProducts(@RequestBody Map data, HttpServletRequest request) {
        String userEmail = request.getUserPrincipal().getName();
        if(userEmail.isEmpty()) {
            Map<String, Object> err = Map.of("err", "pls login");
            return new ResponseEntity<>(err, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }

        List productIds = (List) data.get("product_ids");

        List<ProductDto> products = productService.getProductsByIds(productIds);

        Map<String, Object> msg = Map.of(
          "msg", "set default address OK!",
          "products", products
        );
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }






}
