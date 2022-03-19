package com.coffeestore.model.user;

import com.coffeestore.model.feedback.Feedback;

import com.coffeestore.model.product.RatingProduct;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence" // same as NAME in SequenceGenerator
    )
    private Long id;

    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Collection<Address> addresses;

//    @JsonBackReference
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private Collection<Orders> Orders;

    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Collection<Feedback> feedbacks;

    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Collection<RatingProduct> ratingProducts;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String email;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String password;

    @Transient
    private String passwordConfirm;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = true)
    private Calendar birthday;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String avatar;

    @Column(columnDefinition = "integer", nullable = true)
    private int gender;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = true)
    private Calendar created_at;

    @Column(columnDefinition = "varchar", nullable = true)
    private String phone;



}
