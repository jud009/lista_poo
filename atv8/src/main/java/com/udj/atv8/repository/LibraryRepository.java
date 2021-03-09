package com.udj.atv8.repository;

import com.udj.atv8.domain.Book;
import com.udj.atv8.domain.LibraryBook;

import java.util.List;

public interface LibraryRepository {

    List<LibraryBook> listAll();

    LibraryBook borrow(long bookId);

    void giveBack(Book book);

    LibraryBook addBook(Book book);

    void removeBook(Long bookId);

}
