package com.springprogramming.crud_app.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Der Benutzer mir dieser ID: " + id + "Konnten nicht gefunden werden!");
    }
}
