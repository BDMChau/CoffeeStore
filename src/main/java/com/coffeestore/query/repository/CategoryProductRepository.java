package com.coffeestore.query.repository;

import com.coffeestore.model.product.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Long> {

    @Query("SELECT cp " +
           "FROM CategoryProduct cp " +
           "WHERE cp.product.id =?1")
    Optional<CategoryProduct> findByProductId(Long product_id);
}
