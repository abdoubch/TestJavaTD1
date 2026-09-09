package org.example;

public class DeplacementImpossible extends Exception {

    public DeplacementImpossible() {
        super("Ce déplacement n'est pas autorisé");
    }

    public DeplacementImpossible(String message) {
        super(message);
    }
}