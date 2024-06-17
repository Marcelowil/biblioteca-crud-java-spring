package com.library.crud.repositories;

import com.library.crud.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Long, Book> {
}
