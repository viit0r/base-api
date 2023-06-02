package com.viit0r.baseapi.controller;

import com.viit0r.baseapi.model.request.PersonRequestDTO;
import com.viit0r.baseapi.model.response.PersonResponseDTO;
import com.viit0r.baseapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(personService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonResponseDTO>> findAll() {
        return ResponseEntity.ok().body(personService.findAll());
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> create(@RequestBody PersonRequestDTO personRequestDTO, UriComponentsBuilder uriBuilder) {
        PersonResponseDTO personResponseDTO = personService.create(personRequestDTO);

        URI uri = uriBuilder.path("/people/{id}").buildAndExpand(personResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(personResponseDTO);
    }

    @PutMapping
    public ResponseEntity<PersonResponseDTO> update(@RequestBody PersonRequestDTO personRequestDTO) {
        return ResponseEntity.ok().body(personService.update(personRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(personService.delete(id));
    }
}
