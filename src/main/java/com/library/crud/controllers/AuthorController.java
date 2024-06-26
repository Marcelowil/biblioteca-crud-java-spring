package com.library.crud.controllers;

import com.library.crud.dto.AuthorDTO;
import com.library.crud.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AuthorDTO> findById(@PathVariable Long id){
        AuthorDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> insert(@RequestBody AuthorDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AuthorDTO> update(@PathVariable Long id, @RequestBody AuthorDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
