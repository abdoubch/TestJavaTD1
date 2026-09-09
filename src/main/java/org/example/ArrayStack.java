package org.example;

public class ArrayStack implements Stack {

    private int[] elements;
    private int taille;

    public ArrayStack() {
        this.elements = new int[10];
        this.taille = 0;
    }

    @Override
    public boolean isEmpty() {
        return taille == 0;
    }

    @Override
    public int getSize() {
        return taille;
    }

    @Override
    public void push(int item) {
        if (taille == elements.length) {
            elements = java.util.Arrays.copyOf(elements, elements.length * 2);
        }
        elements[taille] = item;
        taille++;
    }

    @Override
    public int peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[taille - 1];
    }

    @Override
    public int pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        taille--;
        return elements[taille];
    }
    @Override
    public int peek(int index) throws NoSuchElementException {
        if (index < 0 || index >= taille) {
            throw new NoSuchElementException("Index invalide : " + index);
        }
        return elements[index];
    }
}
