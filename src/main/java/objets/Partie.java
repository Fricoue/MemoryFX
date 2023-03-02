package objets;


import javafx.collections.ObservableList;

import java.util.Collections;

public class Partie {

    private int tempsRestant;
    private int pairesRestantes;
    private final ObservableList<Carte> listeCartes;
    private int score;
    private final int difficulte;
    private int hauteur;
    private int largeur;

    public Partie(ObservableList<Carte> listeCartes, int difficulte) {
        this.listeCartes = listeCartes;
        this.tempsRestant = 0;
        this.pairesRestantes = listeCartes.size()/2;
        this.score = 0;
        this.difficulte = difficulte;
        this.hauteur = 0;
        this.largeur = 0;
    }

    public void demarrerPartie() {
        Collections.shuffle(listeCartes); // mélange les cartes
        creerGrille(difficulte);
    }

    private void creerGrille(int difficulte) {
        switch (difficulte) {
            case 0:
                hauteur = 4;
                largeur = 4;
                tempsRestant = 10;
                break;
            case 1:
                hauteur = 8;
                largeur = 8;
                tempsRestant = 5;
                break;
            case 2:
                hauteur = 16;
                largeur = 16;
                tempsRestant = 2;
                break;
            default:
                System.out.println("La difficulté passée en paramètre est incorrecte");
                break;
        }
    }

    private Carte carteRetournee;

    public void setCarteRetournee(Carte carteRetournee) {
        this.carteRetournee = carteRetournee;
    }

    public void retournerCarte(Carte carte) {
        if (!carte.visible()) {
            carte.setVisible(true);
            carte.retourner();
            if (carteRetournee == null) {
                setCarteRetournee(carte);
            } else {
                if (carteRetournee.estPaire(carte)) {
                    carte.retourner();
                    carteRetournee.retourner();
                    carte.setVisible(false);
                    carteRetournee.setVisible(false);
                    setCarteRetournee(null);
                    pairesRestantes--;
                    score += 100;
                } else {
                    carte.retourner();
                    carteRetournee.retourner();
                    carte.setVisible(false);
                    carteRetournee.setVisible(false);
                    setCarteRetournee(null);
                    score -= 20;
                }
            }
        }
    }

    public boolean estTerminee() {
        return (pairesRestantes == 0 || tempsRestant <= 0);
    }

    public int getTempsRestant() {
        return tempsRestant;
    }

    public void setTempsRestant(int temps) {
        this.tempsRestant = temps;
    }

    public int getPairesRestantes() {
        return pairesRestantes;
    }

    public void setPairesRestantes(int pairesRestantes) {
        this.pairesRestantes = pairesRestantes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

}
