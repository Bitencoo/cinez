package com.cinezrest.cinezrest.entities;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "MOVIE")
public class Movie {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "RELEASE_YEAR")
    private String releaseYear;

    @Column
    @ManyToMany
    private List<Person> directorList;

    @Column(name = "CAST")
    private List<Person> castList;

    @Column(name = "DURATION")
    private Time movieDuration;

    @Column(name = "RATING")
    private Double rating;

    @Column(name = "LANGUAGE")
    private String language;
}
