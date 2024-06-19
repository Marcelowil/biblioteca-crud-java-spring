package com.library.crud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.crud.entities.Book;

import java.time.LocalDate;

public class BookDTO {
    private Long id;
    private String title;
    private String isbn;
    private LocalDate publishDate;
    private AuthorDTO authorDTO;

    public BookDTO(Long id, String title, String isbn, LocalDate publishDate, AuthorDTO authorDTO) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.authorDTO = authorDTO;
    }

    public BookDTO(Book book){
        id = book.getId();
        title = book.getTitle();
        isbn = book.getIsbn();
        publishDate = book.getPublishDate();
        authorDTO = new AuthorDTO(book.getAuthor());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }
}
