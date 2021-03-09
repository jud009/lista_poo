package com.udj.atv8.domain;

import java.util.Date;

public class Book {
    private Long bookId;
    private String author;
    private String name;
    private String publisherName;
    private Date publishedYear;

    public Book(){}

    public Book(Long bookId, String author, String name, String publisherName, Date publishedYear) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.publisherName = publisherName;
        this.publishedYear = publishedYear;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Date getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Date publishedYear) {
        this.publishedYear = publishedYear;
    }
}
