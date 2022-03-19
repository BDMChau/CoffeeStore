package com.coffeestore.model.product;

import com.coffeestore.model.feedback.Feedback;
import com.coffeestore.model.order.OrderDetail;
import com.coffeestore.model.rating_product.RatingProduct;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "product")
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence" // same as NAME in SequenceGenerator
    )
    private Long id;

    @JsonBackReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<CategoryProduct> categoryProducts;

    @JsonBackReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<OrderDetail> orderDetails;

    @JsonBackReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<ProductImage> productImages;

    @JsonBackReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<Feedback> feedbacks;

    @JsonBackReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<RatingProduct> ratingProducts;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String name;

    @Column(columnDefinition = "NUMERIC", nullable = true)
    private BigDecimal price;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    @Column(columnDefinition = "INT default 0", nullable = false)
    private int count_views;

    @Column(columnDefinition = "INT default 0", nullable = false)
    private int count_purchased;

    @Column(columnDefinition = "INT default 0", nullable = false)
    private int count_rating;

    @Column(columnDefinition = "bigint default 0l", nullable = false)
    private Long rating_star;
}