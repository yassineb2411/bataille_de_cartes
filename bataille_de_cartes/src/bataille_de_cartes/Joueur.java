package bataille_de_cartes;

import java.util.List;
import java.util.ArrayList;

public class Joueur {
    private String nom;
    private ArrayList<Carte> paquet;
    private int score;

    public Joueur(String _nom, ArrayList<Carte> _paquet, int _score){
        this.nom = _nom;
        this.paquet = new ArrayList<>();
        this.score = _score;
    }

    public Joueur(){
        this.nom = "";
        this.paquet = new ArrayList<>();
        this.score = 0;
    }

    public List<Carte> getPaquet() {
        return paquet;
    }

    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int _score) {
        this.score = _score;
    }

    public void setNom(String _nom) {
        this.nom = _nom;
    }

    public Carte tirerCarte(List<Carte> jeuDeCartes) {
        Carte carteTiree = null;
        if (!jeuDeCartes.isEmpty()) {
            carteTiree = jeuDeCartes.removeLast();
        } else {
            System.out.println("Le jeu est vide, impossible de tirer une carte.");
        }
        return carteTiree;
    }

    public void ajouterCarte(Carte carte){
        this.paquet.add(carte);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nom du Joueur: ").append(nom).append("\n");
        sb.append("Score: ").append(score).append("\n");
        return sb.toString();
    }
}
