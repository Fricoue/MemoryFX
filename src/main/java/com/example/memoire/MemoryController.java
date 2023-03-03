package com.example.memoire;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objets.Partie;

import java.io.IOException;

/**
 * Controller pour la gestion du menu du jeu memory
 * @author Enzo Fricou
 */
public class MemoryController {

    @FXML
    protected void nouvellePartie(ActionEvent event) throws IOException {
        System.out.println("Nouvelle Partie");

        Partie partie = Partie.initialize();

        if (partie != null) {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("grille.fxml")
            );

            Stage stage = new Stage();
            stage.setScene(
                new Scene(loader.load(), 1000, 800)
            );

            PartieController controller = loader.getController();
            controller.receptionDonnees(partie);

            stage.show();
        }

    }

    @FXML
    protected void editerCartes() {
        System.out.println("Editer Cartes");
    }
}