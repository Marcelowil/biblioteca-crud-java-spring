package com.library.crud.services;

import com.library.crud.dto.AuthorDTO;
import com.library.crud.dto.BookDTO;
import com.library.crud.entities.Author;
import com.library.crud.entities.Book;
import com.library.crud.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    @Transactional(readOnly = true)
    public BookDTO findById(Long id){
        Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
        return new BookDTO(book);
    }

    @Transactional(readOnly = true)
    public List<BookDTO> findAll(){
        List<Book> list = repository.findAll();
        return list.stream().map(x -> new BookDTO(x)).toList();
    }

    @Transactional
    public BookDTO insert(BookDTO dto){
        Book book = new Book();
        convertToEntity(dto, book);
        repository.save(book);
        return new BookDTO(book);
    }

    @Transactional
    public BookDTO update(Long id, BookDTO dto){
        Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("Recurso não encontrado"));
        convertToEntity(dto, book);
        book = repository.save(book);
        return new BookDTO(book);
    }

    @Transactional
    public void deleteById(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Recurso não encotrado");
        }
        repository.deleteById(id);
    }

    public void convertToEntity(BookDTO dto, Book book){
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setPublishDate(dto.getPublishDate());
        book.setAuthor(dto.getAuthor());
    }
}
