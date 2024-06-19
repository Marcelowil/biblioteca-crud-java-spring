package com.library.crud.services;

import com.library.crud.dto.AuthorDTO;
import com.library.crud.entities.Author;
import com.library.crud.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional(readOnly = true)
    public List<AuthorDTO> findAll(){
        List<Author> list = repository.findAll();
        return list.stream().map(x -> new AuthorDTO(x)).toList();
    }

    @Transactional
    public AuthorDTO insert(AuthorDTO dto){
        Author author = new Author();
        convertToEntity(dto, author);
        author = repository.save(author);
        return new AuthorDTO(author);
    }

    @Transactional
    public AuthorDTO update(Long id, AuthorDTO dto){
        Author author = repository.findById(id).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
        convertToEntity(dto, author);
        author = repository.save(author);
        return new AuthorDTO(author);
    }
    

    private void convertToEntity (AuthorDTO dto, Author author){
        author.setName(dto.getName());
        author.setBirthDate(dto.getBirthDate());
        author.setNationality(dto.getNationality());
    }
}
