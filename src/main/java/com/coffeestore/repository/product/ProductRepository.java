package com.coffeestore.repository.product;

import com.coffeestore.model.feedback.Feedback;
import com.coffeestore.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



}
