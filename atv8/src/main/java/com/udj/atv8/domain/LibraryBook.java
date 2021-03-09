package com.udj.atv8.domain;

import com.udj.atv8.enums.LibraryBookStatus;

import java.util.ArrayList;
import java.util.List;

public class LibraryBook {

    private Book book;
    private LibraryBookStatus status;

    public LibraryBook(){}

    public LibraryBook(Book book, LibraryBookStatus status) {
        this.book = book;
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LibraryBookStatus getStatus() {
        return status;
    }

    public void setStatus(LibraryBookStatus status) {
        this.status = status;
    }
}
