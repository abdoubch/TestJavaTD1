package org.example;

public class EmptyStackException extends RuntimeException {

    public EmptyStackException() {
        super("La pile est vide");
    }

    public EmptyStackException(String message) {
        super(message);
    }
}
