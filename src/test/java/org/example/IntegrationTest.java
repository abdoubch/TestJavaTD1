package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntegrationTest {

    @Test
    void resolutionDeBoutEnBoutAvecQuatreAnneaux() {
        // On construit la chaîne complète nous-mêmes, comme le ferait le Main

        ToursDeHanoi solveur = new ToursDeHanoiImpl();      // utilise sa propre ToursImpl en interne

        String resultat = solveur.resolutionProbleme(4);

        int deplacementsAttendus = (int) Math.pow(2, 4) - 1; // 15
        long nombreEtats = resultat.lines().filter(l -> l.equals(" A | B | C")).count();

        assertEquals(deplacementsAttendus + 1, nombreEtats); // état initial + 15 déplacements
    }

    @Test
    void unDeplacementInvalideEstBienDetectePendantUnUsageReel() {
        Tours tours = new ToursImpl();
        tours.initialiserTours(2);

        // Anneau 1 (petit) déplacé de A vers C : autorisé
        assertDoesNotThrow(() -> tours.deplacerAnneau(1, 3));

        // Anneau 2 (grand, seul sur A) vers C (qui contient 1, plus petit) : interdit
        assertThrows(DeplacementImpossible.class,
                () -> tours.deplacerAnneau(1, 3));
    }
}