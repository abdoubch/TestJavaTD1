package org.example;

public interface Tours {


    void initialiserTours(int nombreAnneaux);


    String afficherTours();


    void deplacerAnneau(int tourDepart, int tourArrivee) throws DeplacementImpossible;
}
