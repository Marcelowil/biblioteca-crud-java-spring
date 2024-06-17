package com.library.crud.dto;

import com.library.crud.entities.Author;
import com.library.crud.entities.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AuthorDTO {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String nationality;

    private List<Book> books = new ArrayList<>();

    public AuthorDTO(Author author){
        id = author.getId();
        name = author.getName();
        birthDate = author.getBirthDate();
        nationality = author.getNationality();
        books = author.getBooks();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public List<Book> getBooks() {
        return books;
    }
}
