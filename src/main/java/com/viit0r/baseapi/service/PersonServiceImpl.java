package com.viit0r.baseapi.service;

import com.viit0r.baseapi.exception.PersonNotFoundException;
import com.viit0r.baseapi.model.entity.Person;
import com.viit0r.baseapi.model.request.PersonRequestDTO;
import com.viit0r.baseapi.model.response.PersonResponseDTO;
import com.viit0r.baseapi.repository.PersonRepository;
import com.viit0r.baseapi.util.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    private PersonMapper personMapper;

    @Override
    public PersonResponseDTO findById(Long id) {
        Person person = returnPerson(id);
        return personMapper.toPersonDTO(person);
    }

    @Override
    public List<PersonResponseDTO> findAll() {
        return personMapper.toPeopleDTO(personRepository.findAll());
    }

    @Override
    public PersonResponseDTO create(PersonRequestDTO personDTO) {
        Person person = personRepository.save(personMapper.toPerson(personDTO));
        return personMapper.toPersonDTO(person);
    }

    @Override
    public PersonResponseDTO update(PersonRequestDTO personDTO, Long id) {
        Person person = returnPerson(id);
        person = personMapper.updatePersonData(personDTO, person);
        return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public String delete(Long id) {
        Person person = returnPerson(id);
        personRepository.delete(person);
        return "Person with id " + id + " deleted sucessfully!";
    }

    public Person returnPerson(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("ID " + id +" doesn't exist in database."));
    }
}
