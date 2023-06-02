package com.viit0r.baseapi.util;

import com.viit0r.baseapi.model.entity.Person;
import com.viit0r.baseapi.model.request.PersonRequestDTO;
import com.viit0r.baseapi.model.response.PersonResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {
    public PersonResponseDTO toPersonDTO(Person person) {
        return new PersonResponseDTO(person);
    }

    public List<PersonResponseDTO> toPeopleDTO(List<Person> people) {
        return people.stream().map(PersonResponseDTO::new).collect(Collectors.toList());
    }

    public Person toPerson(PersonRequestDTO personDTO) {
        return Person.builder()
                .name(personDTO.getName())
                .age(personDTO.getAge())
                .city(personDTO.getCity())
                .build();
    }

    public Person updatePersonData(PersonRequestDTO personDTO, Person person) {
        person.setName(personDTO.getName());
        person.setAge(personDTO.getAge());
        person.setCity(personDTO.getCity());
        return person;
    }
}
