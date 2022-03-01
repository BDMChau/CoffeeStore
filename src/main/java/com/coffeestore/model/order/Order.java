package com.coffeestore.model.order;

import com.coffeestore.model.delivery.Delivery;
import com.coffeestore.model.feedback.Feedback;
import com.coffeestore.model.payment.Payment;
import com.coffeestore.model.user.Address;
import com.coffeestore.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "order")
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence" // same as NAME in SequenceGenerator
    )
    private Long id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @JsonBackReference
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Collection<OrderDetail> orderDetails;

    @JsonBackReference
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Collection<Feedback> feedbacks;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String email;

    @Column(columnDefinition = "VARCHAR")
    private String phone;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String descriptions;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = true)
    private Calendar created_at;

    @Column(columnDefinition = "<NUMERIC>", nullable = true)
    private BigDecimal total_bill;

    @Column(columnDefinition = "NUMERIC", nullable = true)
    private BigDecimal Shipping_fee;

    @Column(columnDefinition = "NUMERIC", nullable = true)
    private BigDecimal discount_shipping_fee;

}

