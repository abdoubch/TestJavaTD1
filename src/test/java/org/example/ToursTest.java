package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToursTest {
    @Test
    void afficherToursAvecUnAnneauApresInitialisation() {
        Tours tours = new ToursImpl();

        tours.initialiserTours(1);

        String attendu = " A | B | C\n"
                + "---------------\n"
                + " 1 |   |  \n";

        assertEquals(attendu, tours.afficherTours());
    }
    @Test
    void deplacerAnneauValideVersUneTourVide() throws DeplacementImpossible {
        Tours tours = new ToursImpl();
        tours.initialiserTours(1);

        tours.deplacerAnneau(1, 3); // tour A (1) vers tour C (3)

        String attendu = " A | B | C\n"
                + "---------------\n"
                + "   |   | 1\n";
        assertEquals(attendu, tours.afficherTours());
    }
    @Test
    void deplacerDepuisUneTourVideLeveDeplacementImpossible() {
        Tours tours = new ToursImpl();
        tours.initialiserTours(1);

        assertThrows(DeplacementImpossible.class,
                () -> tours.deplacerAnneau(2, 3)); // tour B est vide
    }

    @Test
    void deplacerUnGrandAnneauSurUnPetitLeveDeplacementImpossible() throws DeplacementImpossible {
        Tours tours = new ToursImpl();
        tours.initialiserTours(2);

        tours.deplacerAnneau(1, 2); // anneau 1 (petit) va sur B


        assertThrows(DeplacementImpossible.class,
                () -> tours.deplacerAnneau(1, 2));
    }

    @Test
    void deplacerVersLaMemeTourLeveDeplacementImpossible() {
        Tours tours = new ToursImpl();
        tours.initialiserTours(1);

        assertThrows(DeplacementImpossible.class,
                () -> tours.deplacerAnneau(1, 1));
    }
}
