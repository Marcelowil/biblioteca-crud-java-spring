package com.library.crud.controllers;

import com.library.crud.dto.BookDTO;
import com.library.crud.entities.Book;
import com.library.crud.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable Long id){
        BookDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll(){
       List<BookDTO> dto = service.findAll();
       return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<BookDTO> insert(@RequestBody BookDTO dto){
        dto = service.insert(dto);
        return ResponseEntity.ok(dto);
    }
}
