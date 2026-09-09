package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ToursDeHanoiTest {

    @Test
    void resolutionAvecUnAnneauProduitDeuxEtats() {
        ToursDeHanoi solveur = new ToursDeHanoiImpl();

        String resultat = solveur.resolutionProbleme(1);

        // état initial + 1 déplacement = 2 affichages de plateau
        long nombreEntetes = resultat.lines().filter(l -> l.equals(" A | B | C")).count();
        assertEquals(2, nombreEntetes);
    }
    @Test
    void resolutionAvecDeuxAnneauxProduitQuatreEtats() {
        ToursDeHanoi solveur = new ToursDeHanoiImpl();

        String resultat = solveur.resolutionProbleme(2);

        // état initial + 3 déplacements (2^2 - 1) = 4 affichages
        long nombreEntetes = resultat.lines().filter(l -> l.equals(" A | B | C")).count();
        assertEquals(4, nombreEntetes);
    }

    @Test
    void resolutionAvecTroisAnneauxProduitHuitEtats() {
        ToursDeHanoi solveur = new ToursDeHanoiImpl();

        String resultat = solveur.resolutionProbleme(3);

        // état initial + 7 déplacements (2^3 - 1) = 8 affichages
        long nombreEntetes = resultat.lines().filter(l -> l.equals(" A | B | C")).count();
        assertEquals(8, nombreEntetes);
    }
}
