package com.coffeestore.service;

import com.coffeestore.model.product.Brand;
import com.coffeestore.model.product.Category;
import com.coffeestore.model.product.Product;
import com.coffeestore.query.repository.BrandRepository;
import com.coffeestore.query.repository.CategoryRepository;
import com.coffeestore.query.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public SearchService(BrandRepository brandRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public List<Brand> searchBrand(String name){
        List<Brand> brands = brandRepository.findByNameContaining(name);
        if(brands.isEmpty()){
            return new ArrayList<>();
        }
        return brands;
    }
    public List<Category> searchCate(String name){
        List<Category> categories = categoryRepository.findByNameContaining(name);
        if(categories.isEmpty()){
            return new ArrayList<>();
        }
        return categories;
    }
    public List<Product> searchProduct(String name){
        List<Product> products = productRepository.findByNameContaining(name);
        if(products.isEmpty()){
            return new ArrayList<>();
        }
        return products;
    }
}
