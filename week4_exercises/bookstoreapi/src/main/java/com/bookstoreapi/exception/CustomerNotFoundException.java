package com.bookstoreapi.exception;

public class CustomerNotFoundException extends RuntimeException {
    // Add a serialVersionUID
    private static final long serialVersionUID = 1L;

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
