package com.cinezrest.cinezrest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {

    private Long id;
    private String title;
    private String description;
    private String releaseYear;
    private List<PersonDTO> directorList;
    private List<PersonDTO> castList;
    private Time movieDuration;
    private Double rating;
    private String language;
}
