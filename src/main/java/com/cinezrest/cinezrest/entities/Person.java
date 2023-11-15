package com.cinezrest.cinezrest.entities;

import com.cinezrest.cinezrest.enums.PersonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PersonType personType;

    @ManyToMany(mappedBy = "CAST")
    private List<Movie> movies;
}

