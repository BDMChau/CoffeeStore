package com.coffeestore.model.delivery;

import com.coffeestore.model.product.CategoryProduct;
import com.coffeestore.model.product.Nation;
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
@Table(name = "delivery")
public class Delivery {
    @Id
    @SequenceGenerator(
            name = "delivery_sequence",
            sequenceName = "delivery_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "delivery_sequence" // same as NAME in SequenceGenerator
    )
    private Long id;

//    @JsonManagedReference
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "nation_id")
//    private Nation nation_id;
//
//    @JsonBackReference
//    @OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL)
//    private Collection<CategoryProduct> categoryProducts;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    @Column(columnDefinition = "TEXT")
    private String logo_url;

}
