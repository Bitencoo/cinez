package com.cinezrest.cinezrest.services;

import com.cinezrest.cinezrest.dtos.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public PersonDTO savePerson(PersonDTO personDTO) {
        return null;
    }

    @Override
    public List<PersonDTO> getPersons() {
        return null;
    }

    @Override
    public Optional<PersonDTO> getPersonById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<PersonDTO> updatePersonById(Long id, PersonDTO personDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<PersonDTO> updatePersonPatchById(Long id, PersonDTO personDTO) {
        return Optional.empty();
    }

    @Override
    public boolean deletePersonById(Long id) {
        return false;
    }
}
