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

    public AuthorDTO(Long id, String name, LocalDate birthDate, String nationality) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.nationality = nationality;
    }

    public AuthorDTO(Author author){
        id = author.getId();
        name = author.getName();
        birthDate = author.getBirthDate();
        nationality = author.getNationality();
        books.addAll(author.getBooks());
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
