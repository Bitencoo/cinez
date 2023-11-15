package com.cinezrest.cinezrest.mappers;

import com.cinezrest.cinezrest.dtos.PersonDTO;
import com.cinezrest.cinezrest.entities.Person;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {
    Person personDtoToPerson(PersonDTO personDTO);
    PersonDTO personToPersonDTO(Person person);
}
