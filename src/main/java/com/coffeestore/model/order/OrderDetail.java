package com.coffeestore.model.order;

import com.coffeestore.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @SequenceGenerator(
            name = "order_detail_sequence",
            sequenceName = "order_detail_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_detail_sequence" // same as NAME in SequenceGenerator
    )
    private Long id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order_id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product_id;
//
//    @JsonBackReference
//    @OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL)
//    private Collection<CategoryProduct> categoryProducts;

    @Column(columnDefinition = "INT", nullable = false)
    private int product_quantity;

    @Column(columnDefinition = "NUMERIC", nullable = true)
    private BigDecimal product_price;

    @Column(columnDefinition = "TEXT")
    private String logo_url;


}