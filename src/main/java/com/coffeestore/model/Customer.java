package com.coffeestore.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "customer")
@Entity
@Data
public class Customer  {

  //  private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence" // same as NAME in SequenceGenerator
    )
    private Long Id;

//    @JsonBackReference
//    @OneToMany(mappedBy = "coinUsageWay", cascade = CascadeType.ALL)
//    private Collection<CoinUsageWay> coinUsageWays;

//    @ManyToMany(mappedBy = "genre") // variable genre in manga class
//    private Collection<MangaGenre> mangaGenre;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Calendar date_of_Birth;

    @Column(name = "testing", nullable = false)
    private String testing;

}