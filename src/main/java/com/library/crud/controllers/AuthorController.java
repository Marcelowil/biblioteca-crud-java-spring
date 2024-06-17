package com.library.crud.controllers;

import com.library.crud.dto.AuthorDTO;
import com.library.crud.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
    @Autowired
    private AuthorService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AuthorDTO> findById(@PathVariable Long id){
        AuthorDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

}
