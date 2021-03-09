package com.udj.atv8.service;

import com.udj.atv8.domain.Book;
import com.udj.atv8.domain.LibraryBook;
import com.udj.atv8.enums.LibraryBookStatus;
import com.udj.atv8.repository.LibraryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LibraryService implements LibraryRepository {

    private static final String BAD_REQUEST_MESSAGE = "BOOK NOT FOUND";
    private static final String NOT_FOUND_AVAILABLE = "BOOK NOT AVAILABLE";

    private final List<LibraryBook> books = new ArrayList<>(List.of(
            new LibraryBook(new Book(1L, "author", "name", "publisherName",
                    new Date()), LibraryBookStatus.AVAILABLE),
            new LibraryBook(new Book(2L, "author", "name", "publisherName",
                    new Date()), LibraryBookStatus.AVAILABLE),
            new LibraryBook(new Book(3L, "author", "name", "publisherName",
                    new Date()), LibraryBookStatus.AVAILABLE)
    ));

    @Override
    public List<LibraryBook> listAll() {
        return books;
    }

    @Override
    public LibraryBook borrow(long bookId) {
        LibraryBook borrowedBook = books.stream().filter(x -> x.getBook().getBookId().equals(bookId)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, BAD_REQUEST_MESSAGE));
        if (borrowedBook.getStatus() == LibraryBookStatus.AVAILABLE) {
            borrowedBook.setStatus(LibraryBookStatus.BORROWED);
            return borrowedBook;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_AVAILABLE);
        }
    }

    @Override
    public void giveBack(Book book) {
        LibraryBook borrowedBook = books.stream().filter(x -> x.getBook().getBookId().equals(book.getBookId()))
                .findFirst().orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, BAD_REQUEST_MESSAGE));
        borrowedBook.setStatus(LibraryBookStatus.AVAILABLE);
        int index = books.indexOf(borrowedBook);
        books.set(index, borrowedBook);
    }

    @Override
    public LibraryBook addBook(Book book) {
        LibraryBook newBook = new LibraryBook(book, LibraryBookStatus.AVAILABLE);
        books.add(newBook);
        return newBook;
    }

    @Override
    public void removeBook(Long bookId) {
        LibraryBook borrowedBook = books.stream().filter(x -> x.getBook().getBookId().equals(bookId)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, BAD_REQUEST_MESSAGE));
        books.remove(borrowedBook);
    }


}
