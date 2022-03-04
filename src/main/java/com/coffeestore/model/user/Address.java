package com.coffeestore.model.user;

import com.coffeestore.model.orders.Order;
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
@Table(name = "address")
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence" // same as NAME in SequenceGenerator
    )
    private Long id;


    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonBackReference
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private Collection<Order> orders;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String city_province;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String ward;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String district;

    @Column(columnDefinition = "varchar", nullable = true)
    private String address;



}