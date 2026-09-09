package org.example;


public interface Stack {
    boolean isEmpty();
    int getSize();
    void push(int item);
    int peek() throws EmptyStackException;
    int pop() throws EmptyStackException;
    int peek(int index) throws NoSuchElementException;
}
