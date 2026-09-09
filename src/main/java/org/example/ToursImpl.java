package org.example;

public class ToursImpl implements Tours {

    private Stack tourA;
    private Stack tourB;
    private Stack tourC;
    private int nombreAnneaux;

    @Override
    public void initialiserTours(int nombreAnneaux) {
        this.nombreAnneaux = nombreAnneaux;
        this.tourA = new ArrayStack();
        this.tourB = new ArrayStack();
        this.tourC = new ArrayStack();

        // le plus grand anneau tout au fond, le plus petit (1) au sommet
        for (int anneau = nombreAnneaux; anneau >= 1; anneau--) {
            tourA.push(anneau);
        }
    }

    @Override
    public String afficherTours() {
        StringBuilder sb = new StringBuilder();
        sb.append(" A | B | C\n");
        sb.append("---------------\n");

        for (int ligne = 0; ligne < nombreAnneaux; ligne++) {
            int index = nombreAnneaux - 1 - ligne;
            sb.append(' ').append(cellule(tourA, index));
            sb.append(" | ").append(cellule(tourB, index));
            sb.append(" | ").append(cellule(tourC, index));
            sb.append('\n');
        }
        return sb.toString();
    }

    private String cellule(Stack tour, int index) {
        if (index >= 0 && index < tour.getSize()) {
            return String.valueOf(tour.peek(index));
        }
        return " ";
    }

    @Override
    public void deplacerAnneau(int tourDepart, int tourArrivee) throws DeplacementImpossible {
        if (tourDepart == tourArrivee) {
            throw new DeplacementImpossible("La tour de départ et d'arrivée sont identiques");
        }
        Stack depart = getTour(tourDepart);
        Stack arrivee = getTour(tourArrivee);

        if (depart.isEmpty()) {
            throw new DeplacementImpossible("La tour de départ " + tourDepart + " est vide");
        }
        int anneau = depart.peek();
        if (!arrivee.isEmpty() && arrivee.peek() < anneau) {
            throw new DeplacementImpossible("Impossible de poser l'anneau " + anneau + " sur un anneau plus petit");
        }

        depart.pop();
        arrivee.push(anneau);
    }

    private Stack getTour(int numero) {
        switch (numero) {
            case 1: return tourA;
            case 2: return tourB;
            case 3: return tourC;
            default: throw new IllegalArgumentException("Numéro de tour invalide : " + numero);
        }
    }
}