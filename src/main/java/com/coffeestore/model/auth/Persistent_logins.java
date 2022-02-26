package com.coffeestore.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "persistent_logins")
public class Persistent_logins {

    @Id
    @Column(columnDefinition = "TEXT", nullable = true)
    private String series;


    @Column(columnDefinition = "TEXT", nullable = true)
    private String username;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String token;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = true)
    private String last_used;

}
