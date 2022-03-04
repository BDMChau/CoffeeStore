package com.coffeestore.model.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "product_image")
public class ProductImage {
    @Id
    @SequenceGenerator(
            name = "product_image_sequence",
            sequenceName = "product_image_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_image_sequence" // same as NAME in SequenceGenerator
    )
    private Long id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
//
//    @JsonBackReference
//    @OneToMany(mappedBy = "delivery_id", cascade = CascadeType.ALL)
//    private Collection<Orders> Orders;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String image_url;

}