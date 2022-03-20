package com.coffeestore.query.repository;

import com.coffeestore.model.product.RatingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<RatingProduct, Long> {
}
