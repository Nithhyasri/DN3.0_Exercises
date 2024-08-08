package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    // Method to save a book
    public void save(String bookName) {
        System.out.println("Book saved: " + bookName);
    }
}