package com.coffeestore.model.feedback;

import com.coffeestore.model.order.Order;
import com.coffeestore.model.product.Product;
import com.coffeestore.model.user.User;
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
@Table(name = "feedback")
public class Feedback {
    @Id
    @SequenceGenerator(
            name = "feedback_sequence",
            sequenceName = "feedback_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "feedback_sequence" // same as NAME in SequenceGenerator
    )
    private Long id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user_id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order_id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product_id;

    @JsonBackReference
    @OneToMany(mappedBy = "feedback_id", cascade = CascadeType.ALL)
    private Collection<FeedbackImage> feedbackImages;

    @Column(columnDefinition = "INT", nullable = false)
    private int rating_star;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Calendar created_at;

}