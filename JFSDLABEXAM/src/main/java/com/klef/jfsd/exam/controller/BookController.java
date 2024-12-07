package com.klef.jfsd.exam.controller;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Optional<Book> updatedBook = bookService.updateBook(id, bookDetails);
        return updatedBook.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
