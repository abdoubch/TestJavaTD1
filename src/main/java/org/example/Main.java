package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int nombreAnneaux = 3;
        if (args.length > 0) {
            try {
                nombreAnneaux = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument invalide, utilisation de la valeur par défaut (3).");
            }
        }

        ToursDeHanoi solveur = new ToursDeHanoiImpl();
        String etapes = solveur.resolutionProbleme(nombreAnneaux);

        System.out.println("Résolution des tours de Hanoï avec " + nombreAnneaux + " anneau(x) :");
        System.out.println();
        System.out.println(etapes);

        int nombreDeplacements = (int) Math.pow(2, nombreAnneaux) - 1;
        System.out.println("Nombre de déplacements effectués : " + nombreDeplacements);
    }
}