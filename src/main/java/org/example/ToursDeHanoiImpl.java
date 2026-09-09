package org.example;

public class ToursDeHanoiImpl implements ToursDeHanoi {

    private final Tours tours;

    public ToursDeHanoiImpl() {
        this.tours = new ToursImpl();
    }

    @Override
    public String resolutionProbleme(int nombreAnneaux) {
        tours.initialiserTours(nombreAnneaux);
        StringBuilder resultat = new StringBuilder();
        resultat.append(tours.afficherTours());

        deplacer(nombreAnneaux, 1, 3, 2, resultat); // de A(1) vers C(3), via B(2)

        return resultat.toString();
    }

    private void deplacer(int nombreAnneaux, int depart, int arrivee, int auxiliaire, StringBuilder resultat) {
        if (nombreAnneaux <= 0) {
            return;
        }
        deplacer(nombreAnneaux - 1, depart, auxiliaire, arrivee, resultat);
        try {
            tours.deplacerAnneau(depart, arrivee);
        } catch (DeplacementImpossible e) {
            throw new IllegalStateException("Déplacement invalide généré par l'algorithme", e);
        }
        resultat.append('\n').append(tours.afficherTours());
        deplacer(nombreAnneaux - 1, auxiliaire, arrivee, depart, resultat);
    }
}