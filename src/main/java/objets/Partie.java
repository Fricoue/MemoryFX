package objets;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

import java.io.File;
import java.util.Collections;

public class Partie {

    private int tempsRestant;
    private int pairesRestantes;
    private final ObservableList<Carte> grille = FXCollections.observableArrayList();
    private int score;
    private int difficulte;
    private int hauteur;
    private int largeur;

    public Partie(File[] listeFichiers, int difficulte) {
        this.pairesRestantes = listeFichiers.length/2;
        this.score = 0;
        this.difficulte = difficulte;
        switch (this.difficulte) {
            case 0:
                this.hauteur = 4;
                this.largeur = 4;
                this.tempsRestant = 10;
                break;
            case 1:
                this.hauteur = 8;
                this.largeur = 8;
                this.tempsRestant = 5;
                break;
            case 2:
                this.hauteur = 16;
                this.largeur = 16;
                this.tempsRestant = 2;
                break;
            default:
                throw new NullPointerException("La difficulté passée en paramètre est incorrecte");
        }

        int nombreCartes = largeur * hauteur;

        // Indice du fichier courant dans la liste des cartes
        int indiceTableauCarte = 0;

        for (int i = 0; i < nombreCartes; i+= 2) {
            if (indiceTableauCarte == listeFichiers.length) {
                indiceTableauCarte = 0;
            }

            for (int j = 0; j < 2; j++) {
                Image imageVisible = new Image(listeFichiers[indiceTableauCarte].getAbsolutePath());

                grille.add(new Carte(Integer.toString(indiceTableauCarte), imageVisible));
            }
            indiceTableauCarte ++;
        }
        Collections.shuffle(grille);

        for (int i = 0; i < grille.size(); i++) {
            grille.get(i).getImageView().setId(Integer.toString(i));
        }
    }

    public static Partie initialize() {
        File dossier = new File("src/main/resources/cartes/cartesVisibles");
        File[] listeFichiers = dossier.listFiles();

        if (listeFichiers == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Une erreur s'est produite");
            alert.setContentText("Aucune carte n'est définie, impossible de lancer une partie");

            alert.showAndWait();
            return null;
        }

        return new Partie(listeFichiers, 0);
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

    public ObservableList<Carte> getGrille() {
        return grille;
    }

}
