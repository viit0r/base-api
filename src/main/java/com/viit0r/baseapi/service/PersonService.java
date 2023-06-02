package com.viit0r.baseapi.service;

import com.viit0r.baseapi.model.request.PersonRequestDTO;
import com.viit0r.baseapi.model.response.PersonResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    PersonResponseDTO findById(Long id);

    List<PersonResponseDTO> findAll();

    PersonResponseDTO create(PersonRequestDTO personDTO);

    PersonResponseDTO update(PersonRequestDTO personDTO, Long id);

    String delete(Long id);
}
