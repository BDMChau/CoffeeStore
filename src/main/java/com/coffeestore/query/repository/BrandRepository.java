package com.coffeestore.query.repository;

import com.coffeestore.model.product.Brand;
import com.coffeestore.query.dto.ProductDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Query("SELECT new com.coffeestore.query.dto.ProductDto("+
           "  br.id "+
           ", pr.id, pr.description, pr.name, pr.price "+
           ", prI.id, prI.image_url) "+
           "FROM Product pr " +
           "LEFT JOIN pr.brand br ON pr.brand.id = br.id "+
           "LEFT JOIN ProductImage prI ON prI.product.id = pr.id "+
           "WHERE br.id =?1 ")
    List<ProductDto> getProductsByBrandId(Long product_id, Pageable pageable);


    @Query("select b from Brand b where upper(b.name) like concat('%',upper(trim(?1) ), '%')")
    List<Brand> findByNameContaining(String name);
}
