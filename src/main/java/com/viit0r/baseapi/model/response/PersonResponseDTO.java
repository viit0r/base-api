package com.viit0r.baseapi.model.response;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class PersonResponseDTO implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String city;
}
