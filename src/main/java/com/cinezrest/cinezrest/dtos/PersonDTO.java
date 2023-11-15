package com.cinezrest.cinezrest.dtos;

import com.cinezrest.cinezrest.enums.PersonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO {

    private Long id;
    private String name;
    private PersonType personType;
    private List<MovieDTO> movies;
}

