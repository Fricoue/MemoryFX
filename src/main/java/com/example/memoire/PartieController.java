package com.example.memoire;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import objets.Partie;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import objets.Carte;
import objets.Partie;

import java.io.File;

public class PartieController {

    private static Partie partie;

    @FXML
    private GridPane gridPane;

    @FXML
    private static Label labelScore;

    @FXML
    private static Label labelChrono;

    private static Carte carteSelectionnee;

    private static Carte autreCarte;

    private static int nbCartesRetournees;

    public void afficheGrille () {
        ObservableList<Carte> grille = partie.getGrille();

        Node[] ligneCourante = new Node[partie.getLargeur()];

        int imageCourante = 0;

        for (int i = 0; i < partie.getHauteur(); i++) {
            for (int j = 0; j < partie.getLargeur(); j++) {
                ligneCourante[j] = grille.get(imageCourante).getImageView();
                imageCourante ++;
            }
            gridPane.addRow(i,ligneCourante);
        }
    }

    public static void retournerCarte(MouseEvent event) {
        ImageView img = (ImageView) event.getSource();
        if (carteSelectionnee == null) {
            carteSelectionnee = partie.getGrille().get(Integer.parseInt(img.getId()));
            System.out.println(carteSelectionnee);
            carteSelectionnee.retourner();
        } else {
            autreCarte = partie.getGrille().get(Integer.parseInt(img.getId()));
            autreCarte.retourner(); // RETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUSRETOURNE TOI PTN JEN PEUX PLUS
            try {
                Thread.sleep(1000); // delay for 1000 milliseconds (1 second)
            } catch (InterruptedException e) {
                // handle the exception (if any)
            }
            if (carteSelectionnee.estPaire(autreCarte)) {
                System.out.println("pair");
                nbCartesRetournees += 2;
                if (partie.estTerminee()) {
                    finDePartie();
                }
            } else {
                System.out.println("non");
                carteSelectionnee.retourner();
                autreCarte.retourner();
            }
            carteSelectionnee = null;
            // labelScore.setText(String.valueOf(partie.getScore()));
        }
    }

    private static void finDePartie() {
        partie.getScore();
        labelChrono.setText("0:00");
        labelScore.setText(String.valueOf(partie.getScore()));
    }

    @FXML
    public void receptionDonnees(Partie partie) {
        this.partie = partie;
        afficheGrille();
    }
}
