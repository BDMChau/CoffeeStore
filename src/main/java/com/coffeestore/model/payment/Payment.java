package com.coffeestore.model.payment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "payment")
public class Payment {
    @Id
    @SequenceGenerator(
            name = "payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_sequence" // same as NAME in SequenceGenerator
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
    private String descriptions;

    @Column(columnDefinition = "TEXT")
    private String logo_url;


}