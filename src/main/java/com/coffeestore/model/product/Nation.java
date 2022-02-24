package com.coffeestore.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "nation")
public class Nation {
    @Id
    @SequenceGenerator(
            name = "nation_sequence",
            sequenceName = "nation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "nation_sequence" // same as NAME in SequenceGenerator
    )
    private Long id;

    @JsonBackReference
    @OneToMany(mappedBy = "nation_id", cascade = CascadeType.ALL)
    private Collection<Category> categories;


//    @ManyToMany(mappedBy = "genre") // variable genre in manga class
//    private Collection<MangaGenre> mangaGenre;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;


}