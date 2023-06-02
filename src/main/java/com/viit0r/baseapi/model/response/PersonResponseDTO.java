package com.viit0r.baseapi.model.response;

import com.viit0r.baseapi.model.entity.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class PersonResponseDTO implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String city;

    public PersonResponseDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
        this.city = person.getCity();
    }
}
