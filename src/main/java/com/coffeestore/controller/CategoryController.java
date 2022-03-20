package com.coffeestore.controller;

import com.coffeestore.model.product.Category;
import com.coffeestore.service.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("")
    public List<Category> getCategories(Model model){
        List<Category> categories = categoryService.getCategories();
        if(categories.isEmpty()){
            model.addAttribute("err","Empty category!");
            return new ArrayList<>();
        }
        return categories;
    }

}
