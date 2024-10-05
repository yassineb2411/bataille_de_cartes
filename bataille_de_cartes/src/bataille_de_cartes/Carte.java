package bataille_de_cartes;

public class Carte {
    public static String[] VALEURS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};
    public static String[] COULEURS = {"Pique", "Coeur", "Trèfle", "Carreau"};

    private String valeur;
    private String couleur;

    public Carte(String _valeur, String _couleur) {
        if (estValeurValide(_valeur) && estCouleurValide(_couleur)) {
            this.valeur = _valeur;
            this.couleur = _couleur;
        } else {
            throw new IllegalArgumentException("Valeur ou couleur invalide");
        }
    }

    public Carte(){
        this.valeur = "";
        this.couleur = "";
    }

    public String getValeur() {
        return valeur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setValeur(String _valeur) {
        if (estValeurValide(_valeur)) {
            this.valeur = _valeur;
        } else {
            throw new IllegalArgumentException("Valeur invalide");
        }
    }

    public void setCouleur(String _couleur) {
        if (estCouleurValide(_couleur)) {
            this.couleur = _couleur;
        } else {
            throw new IllegalArgumentException("Couleur invalide");
        }
    }

    private static boolean estValeurValide(String _valeur) {
        for (String v : VALEURS) {
            if (v.equals(_valeur)) {
                return true;
            }
        }
        return false;
    }

    private static boolean estCouleurValide(String _couleur) {
        for (String c : COULEURS) {
            if (c.equals(_couleur)) {
                return true;
            }
        }
        return false;
    }

    public int comparerCarte(Carte autreCarte) {
        int valeurCarte1 = getValeurIndex(this.valeur);
        int valeurCarte2 = getValeurIndex(autreCarte.getValeur());

        if (valeurCarte1 > valeurCarte2) {
            return 1;
        } else if (valeurCarte1 < valeurCarte2) {
            return -1;
        } else {
            return 0;  
        }
    }

    private int getValeurIndex(String valeur) {
        for (int i = 0; i < VALEURS.length; i++) {
            if (VALEURS[i].equals(valeur)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Valeur invalide : " + valeur);
    }

    public String toString(){
        return valeur + " de " + couleur;
    }
}
