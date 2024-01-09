package com.example.design;

import Classes.Conferencier;
import Classes.Organisateur;
import Classes.Participant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import module.MyJDBC;
import java.io.IOException;

public class InscriptionController {
    @FXML
    private TextField nom_inscription;
    @FXML
    private TextField prenom_inscription;
    @FXML
    private TextField email_inscription;
    @FXML
    private PasswordField mdp_inscription;
    @FXML
    private Button sign_up;
    @FXML
    private Hyperlink link;
    @FXML
    private Label errorLabel;

    @FXML
    private void handle_sign_up() {
        HelloController helloController = new HelloController();

        String nom = nom_inscription.getText();
        String prenom = prenom_inscription.getText();
        String email = email_inscription.getText();
        String motDePasse = mdp_inscription.getText();
        // Vérifier si tous les champs sont remplis
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || motDePasse.isEmpty()) {
            showError("Veuillez remplir tous les champs.");
            return;
        }

        String selectedRole = ApplicationController.getInstance().getSelectedRole();
        MyJDBC myJDBC = new MyJDBC();
        if (email.contains("@") ) {
        try {
            if (myJDBC.emailExiste(email, selectedRole)) {
                showError("L'adresse email existe déjà.");
                return;
            }
                switch (selectedRole) {
                    case "Conferencier":
                        Conferencier conferencier = new Conferencier(nom, prenom, email, motDePasse);
                        myJDBC.inserer_conferencier(conferencier);
                        helloController.afficher_page(selectedRole,selectedRole,sign_up);
                        break;

                    case "Organisateur":
                        Organisateur organisateur = new Organisateur(nom, prenom, email, motDePasse);
                        myJDBC.inserer_organisateur(organisateur);
                        helloController.afficher_page(selectedRole,selectedRole,sign_up);
                        break;

                    case "Participant":
                        Participant participant = new Participant(nom, prenom, email, motDePasse);
                        myJDBC.inserer_participant(participant);
                        helloController.afficher_page(selectedRole,selectedRole,sign_up);
                        break;

                    default:
                        System.out.println("Rôle non pris en charge : " + selectedRole);
                }}
                catch(Exception e){
                    e.printStackTrace();

            }
        }
        else {

            showError("L'adresse e-mail semble incorrecte");
        }
    }
    private void showError(String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }


    @FXML
    private void hundle_btn_inscrire() {
        try {
            // Load the FXML file for the "Connect" page
            FXMLLoader fxmlLoader = new FXMLLoader(Page1.class.getResource("inscription.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1100, 792);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            Image img = new Image("C:\\Users\\hp\\Desktop\\my studies\\GI2\\S1\\POO Java\\project\\design\\src\\main\\resources\\images\\logo2.png");
            Stage stage = new Stage();

            stage.getIcons().add(img);
            stage.setTitle("Page d'inscription");
            stage.setScene(scene);
            stage.show();

            // Close the current Stage
            Stage currentStage = (Stage) link.getScene().getWindow();
            currentStage.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
