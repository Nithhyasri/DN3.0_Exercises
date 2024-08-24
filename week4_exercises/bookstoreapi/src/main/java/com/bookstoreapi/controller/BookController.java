package com.bookstoreapi.controller;

import com.bookstoreapi.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * REST controller for managing books in the online bookstore.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // Sample data initialization (optional)
    public BookController() {
        books.add(new Book(1, "Spring in Action", "Craig Walls", 39.99, "9781617294945"));
        books.add(new Book(2, "Effective Java", "Joshua Bloch", 45.00, "9780134685991"));
        books.add(new Book(3, "Clean Code", "Robert C. Martin", 40.50, "9780132350884"));
    }

    /**
     * Retrieves all books.
     *
     * @return List of all books.
     */
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    /**
     * Adds a new book to the collection.
     *
     * @param book The book to add.
     * @return The added book.
     */
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    /**
     * Retrieves a book by its ID.
     *
     * @param id The ID of the book.
     * @return The book with the specified ID, or null if not found.
     */
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return books.stream()
                    .filter(book -> book.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    /**
     * Searches for books by title and/or author.
     *
     * @param title  The title to search for (optional).
     * @param author The author to search for (optional).
     * @return List of books matching the search criteria.
     */
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author) {
        return books.stream()
                    .filter(book ->
                        (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                        (author == null || book.getAuthor().equalsIgnoreCase(author))
                    )
                    .toList();
    }

    /**
     * Updates an existing book.
     *
     * @param id          The ID of the book to update.
     * @param updatedBook The updated book information.
     * @return The updated book, or null if not found.
     */
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                book.setIsbn(updatedBook.getIsbn());
                return book;
            }
        }
        return null;
    }

    /**
     * Deletes a book by its ID.
     *
     * @param id The ID of the book to delete.
     * @return Confirmation message.
     */
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        boolean removed = books.removeIf(book -> book.getId() == id);
        return removed ? "Book deleted successfully!" : "Book not found.";
    }
}



