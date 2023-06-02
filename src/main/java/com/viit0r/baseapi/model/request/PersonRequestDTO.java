package com.viit0r.baseapi.model.request;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class PersonRequestDTO implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String city;
}
