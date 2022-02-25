package com.coffeestore.model.users;

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
public class Users {
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
    @OneToMany(mappedBy = "users_id", cascade = CascadeType.ALL)
    private Collection<Address> addresses;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role_id;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String email;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String password;

    @Column(columnDefinition = "Date", nullable = true)
    private Calendar birthday;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String avatar;

    @Column(columnDefinition = "integer", nullable = true)
    private String gender;

    @Column(columnDefinition = "Timestamp with time zone", nullable = true)
    private Calendar created_at;

    @Column(columnDefinition = "varchar", nullable = true)
    private String phone;
}
