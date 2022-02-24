package com.coffeestore.model.user;

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
@Table(name = "role")
public class Role {
    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_sequence" // same as NAME in SequenceGenerator
    )
    private Long id;

//    @JsonManagedReference
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "nation_id")
//    private Nation nation_id;

    @JsonBackReference
    @OneToMany(mappedBy = "role_id", cascade = CascadeType.ALL)
    private Collection<User> users;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String name;


}