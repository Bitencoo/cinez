package com.cinezrest.cinezrest.services;

import com.cinezrest.cinezrest.dtos.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PersonService {
    PersonDTO savePerson(PersonDTO personDTO);
    List<PersonDTO> getPersons();
    Optional<PersonDTO> getPersonById(Long id);
    Optional<PersonDTO> updatePersonById(Long id, PersonDTO personDTO);
    Optional<PersonDTO> updatePersonPatchById(Long id, PersonDTO personDTO);
    boolean deletePersonById(Long id);
}
