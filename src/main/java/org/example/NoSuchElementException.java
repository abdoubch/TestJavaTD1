package org.example;

public class NoSuchElementException extends RuntimeException {

    public NoSuchElementException() {
        super("Aucun élément à cet index");
    }

    public NoSuchElementException(String message) {
        super(message);
    }
}
