package com.viit0r.baseapi.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "people")
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private String city;

    @Builder
    public Person(String name, Integer age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
}
