package com.coffeestore.repository.product;

import com.coffeestore.model.feedback.Feedback;
import com.coffeestore.model.product.Product;
import com.coffeestore.repository.dtos.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


//    @Query("""
//            SELECT new com.coffeestore.repository.dtos.ProductDto(br.id, br.name
//            , ca.id, ca.name
//            , pr.id, pr.description, pr.name, pr.price)
//
//            FROM Product pr
//            LEFT JOIN Brand br ON br.id = pr.brand_id.id
//            JOIN CategoryProduct cp ON cp.product_id.id = pr.id
//            JOIN Category ca ON cp.category_id.id = ca.id
//            WHERE ca.id = ?1
//            ORDER BY ca.name
//            """)
//    Optional<ProductDto> getProductByCategoryId(Long category_id);
}
