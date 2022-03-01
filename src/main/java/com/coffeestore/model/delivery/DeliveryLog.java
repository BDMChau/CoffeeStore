package com.coffeestore.model.delivery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "delivery_log")
public class DeliveryLog {
    @Id
    @SequenceGenerator(
            name = "delivery_log_sequence",
            sequenceName = "delivery_log_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "delivery_log_sequence" // same as NAME in SequenceGenerator
    )
    private Long id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
//
//    @JsonBackReference
//    @OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL)
//    private Collection<CategoryProduct> categoryProducts;


    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String status;

    @Column(columnDefinition = "timestamp with time zone", nullable = false)
    private Calendar created_at;



}