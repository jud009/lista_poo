package com.udj.atv8.controller;


import com.udj.atv8.domain.Book;
import com.udj.atv8.domain.LibraryBook;
import com.udj.atv8.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library")
@AllArgsConstructor
public class LibraryController {

    private final LibraryService service;

    @GetMapping
    public ResponseEntity<List<LibraryBook>> listAll() {
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @PostMapping(path = "borrow/{id}")
    public ResponseEntity<LibraryBook> borrow(@PathVariable Long id) {
        return new ResponseEntity<>(service.borrow(id), HttpStatus.OK);
    }

    @PutMapping(path = "return")
    public ResponseEntity<Void> giveBack(@RequestBody Book book) {
        service.giveBack(book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<LibraryBook> add(@RequestBody Book book){
        return new ResponseEntity<>(service.addBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.removeBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
