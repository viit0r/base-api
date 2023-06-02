package com.viit0r.baseapi.repository;

import com.viit0r.baseapi.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
