package com.coffeestore.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @OneToMany(mappedBy = "product_id", cascade = CascadeType.ALL)
    private Collection<CategoryProduct> categoryProducts;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand_id;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

}