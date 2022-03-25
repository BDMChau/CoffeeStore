package com.coffeestore.controller;

import com.coffeestore.model.product.Brand;
import com.coffeestore.model.product.Category;
import com.coffeestore.model.product.Product;
import com.coffeestore.query.dto.ProductDto;
import com.coffeestore.service.SearchService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("")
    public String findByName(@RequestParam("keywords") String name, Model model){
//        List<Brand> brandList = searchService.searchBrand(name);
//        if(!brandList.isEmpty())model.addAttribute("brand_list",brandList);
//
//        List<Category> categories = searchService.searchCate(name);
//        if(!categories.isEmpty()) model.addAttribute("cate_list",categories);

        List<ProductDto> products = searchService.searchProduct(name);
        if(!products.isEmpty()) model.addAttribute("product_list",products);
        else model.addAttribute("error", "nothing found");


        return "search-result";
    }


}
