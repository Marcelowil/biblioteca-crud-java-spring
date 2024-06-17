package com.library.crud.services;

import com.library.crud.dto.AuthorDTO;
import com.library.crud.entities.Author;
import com.library.crud.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    @Transactional(readOnly = true)
    public AuthorDTO findById(Long id){
        Optional<Author> result = repository.findById(id);
        Author author = result.orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
        AuthorDTO dto = new AuthorDTO(author);
        return dto;
    }
}
