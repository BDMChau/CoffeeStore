package com.coffeestore.service.category;

import com.coffeestore.model.product.Category;
import com.coffeestore.query.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        List<Category> categories = categoryRepository.getCategories();
       if(categories.isEmpty()){
           return new ArrayList<>();
       }
       return categories;
    }
}
