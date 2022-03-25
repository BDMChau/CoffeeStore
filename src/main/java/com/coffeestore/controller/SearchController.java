package com.coffeestore.controller;

import com.coffeestore.model.product.Brand;
import com.coffeestore.model.product.Category;
import com.coffeestore.model.product.Product;
import com.coffeestore.service.SearchService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/{name}")
    public String findByName(@PathVariable("name") String name, Model model){
        List<Brand> brandList = searchService.searchBrand(name);
        if(!brandList.isEmpty()){
            model.addAttribute("brand_list",brandList);
        }
        List<Category> categories = searchService.searchCate(name);
        if(!categories.isEmpty()){
            categories.forEach(item->{
                System.err.println("cate: "+item.getName());
            });
            model.addAttribute("cate_list",categories);
        }
        List<Product> products = searchService.searchProduct(name);
        if(!products.isEmpty()){
            products.forEach(item->{
                System.err.println("product: "+item.getName());
            });
            model.addAttribute("product_list",products);
        }

        return "search-result";
    }


}
