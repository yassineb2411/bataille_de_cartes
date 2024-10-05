import bataille_de_cartes.Carte;
import bataille_de_cartes.Joueur;
import java.util.ArrayList;
import java.util.Collections;

public class Bataille {
    public static void main(String[] args) {
        ArrayList<Carte> jeuDeCartes = new ArrayList<>();

        ArrayList<Carte> main1 = new ArrayList<>();
        ArrayList<Carte> main2 = new ArrayList<>();

        Joueur joueur1 = new Joueur("Yassine", main1, 0);
        Joueur joueur2 = new Joueur("Jean", main2, 0);

        for (String couleur : Carte.COULEURS) {
            for (String valeur : Carte.VALEURS) {
                Carte carte = new Carte(valeur, couleur);
                jeuDeCartes.add(carte);
            }
        }

        Collections.shuffle(jeuDeCartes);

        int decompte = 0;

        while (!jeuDeCartes.isEmpty()) {
            decompte++;
            Carte carteJoueur1 = joueur1.tirerCarte(jeuDeCartes);
            Carte carteJoueur2 = joueur2.tirerCarte(jeuDeCartes);

            joueur1.ajouterCarte(carteJoueur1);
            joueur2.ajouterCarte(carteJoueur2);

            int resultatDuel = carteJoueur1.comparerCarte(carteJoueur2);

            if (resultatDuel > 0) {
                joueur1.setScore(joueur1.getScore() + 1);
                System.out.println(joueur1.getNom() + " remporte le pli avec " + carteJoueur1);
            } else if (resultatDuel < 0) {
                joueur2.setScore(joueur2.getScore() + 1);
                System.out.println(joueur2.getNom() + " remporte le pli avec " + carteJoueur2);
            } else {
                System.out.println("Égalité entre " + carteJoueur1 + " et " + carteJoueur2);
            }

            System.out.println(joueur1.toString());
            System.out.println(joueur2.toString());

            if (joueur1.getScore() > joueur2.getScore()) {
                System.out.println("Le vainqueur actuel est " + joueur1.getNom() + " avec " + joueur1.getScore() + " point(s) !");
                System.out.println("-----------------------------------------------------------");
            } else if (joueur2.getScore() > joueur1.getScore()) {
                System.out.println("Le vainqueur actuel est " + joueur2.getNom() + " avec " + joueur2.getScore() + " point(s) !");
                System.out.println("-----------------------------------------------------------");
            } else {
                System.out.println("Il y'a égalité entre les deux joueurs !");
                System.out.println("-----------------------------------------------------------");
            }
            System.out.println("Il y'a eu " + decompte + " pli(s)"+ System.lineSeparator() + "-----------------------------------------------------------");
        }

        if(jeuDeCartes.isEmpty()){
            if (joueur1.getScore() > joueur2.getScore()) {
                System.out.println("Le vainqueur de la partie est " + joueur1.getNom() + " avec " + joueur1.getScore() + " point(s) !");
            } else if (joueur2.getScore() > joueur1.getScore()) {
                System.out.println("Le vainqueur de la partie est " + joueur2.getNom() + " avec " + joueur2.getScore() + " point(s) !");
            } else {
                System.out.println("La partie est une égalité !");
            }
        }
    }
}