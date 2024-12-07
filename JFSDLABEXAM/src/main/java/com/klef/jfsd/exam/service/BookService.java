package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Optional<Book> updateBook(Long id, Book bookDetails) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setGenre(bookDetails.getGenre());
            book.setPrice(bookDetails.getPrice());
            book.setPublishedYear(bookDetails.getPublishedYear());
            return bookRepository.save(book);
        });
    }
}
