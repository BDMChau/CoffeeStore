package com.coffeestore.query.repository;

import com.coffeestore.model.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT ca " +
           "FROM Category ca " +
           "ORDER BY ca.name")
    List<Category> getCategories();

    @Query("select c from Category c where upper(c.name) like concat('%',upper(trim(?1) ), '%')")
    List<Category> findByNameContaining(String name);
}
