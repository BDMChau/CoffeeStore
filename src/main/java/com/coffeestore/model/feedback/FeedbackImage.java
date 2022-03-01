package com.coffeestore.model.feedback;

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
@Table(name = "feedback_image")
public class FeedbackImage {
    @Id
    @SequenceGenerator(
            name = "feedback_image_sequence",
            sequenceName = "feedback_image_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "feedback_image_sequence" // same as NAME in SequenceGenerator
    )
    private Long id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedback_id")
    private Feedback feedback_id;

//    @JsonBackReference
//    @OneToMany(mappedBy = "delivery_id", cascade = CascadeType.ALL)
//    private Collection<Order> orders;

    @Column(columnDefinition = "TEXT")
    private String image_url;

}