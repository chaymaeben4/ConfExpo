package com.example.design;

import Classes.Participant;
import Classes.Conferencier;
import Classes.Organisateur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import com.example.design.HelloController;
import module.MyJDBC;

import java.io.IOException;
import java.sql.*;

import static module.MyJDBC.checkIfUserExists;


public class ConnectController {

    @FXML
    private TextField Usernamefield;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button SeConnecter;

    @FXML
    private Hyperlink link;
    private MyJDBC myJDBC;

    @FXML
    public void handleLoginButton() {
        myJDBC = new MyJDBC();
        String username = Usernamefield.getText();
        String password = PasswordField.getText();
        ApplicationController.getInstance().setUsername(username);
        String selectedRole = ApplicationController.getInstance().getSelectedRole();

        if (checkIfUserExists(username, selectedRole)) {
            switch (selectedRole) {
                case "Conferencier":
                    Conferencier conferencier = MyJDBC.checkCredentials_conf(username, password, selectedRole);
                    if (conferencier != null) {

                        afficher_page("Conferencier" , "Bienvenue Conferencier", SeConnecter) ;
                    } else {
                        showError("Mot de passe invalide. Veuillez réessayer.");
                    }
                    break;

                case "Organisateur":
                    Organisateur organisateur = MyJDBC.checkCredentials_org(username, password, selectedRole);
                    if (organisateur != null) {
                        afficher_page("organisateur" , "Bienvenue Organisateur", SeConnecter) ;
                    } else {
                        showError("Mot de passe invalide. Veuillez réessayer.");
                    }
                    break;

                case "Participant":
                    Participant participant = MyJDBC.checkCredentials_part(username, password, selectedRole);
                    if (participant != null) {
                        afficher_page("participant" , "Bienvenue Participant", SeConnecter) ;
                    } else {
                        showError("Mot de passe invalide. Veuillez réessayer.");
                    }
                    break;

                default:
                    showError("Rôle non reconnu.");
                    break;
            }
        } else {
            showError("Utilisateur non enregistré. Veuillez vous inscrire.");
        }
    }




    public static String getTableName(String role) {
        switch (role.toLowerCase()) {
            case "participant":
                return "participant";
            case "organisateur":
                return "organisateur";
            case "conferencier":
                return "conferencier";
            default:
                throw new IllegalArgumentException("Rôle inconnu : " + role);
        }
    }

    private void showError(String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }
    public void afficher_page( String fichier, String title, Button btn) {
        try {
            // Load the FXML file for the "Connect" page
            FXMLLoader fxmlLoader = new FXMLLoader(Page1.class.getResource(fichier+".fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1100, 792);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            Image img = new Image("C:\\Users\\hp\\Desktop\\my studies\\GI2\\S1\\POO Java\\project\\design\\src\\main\\resources\\images\\logo2.png");
            Stage stage = new Stage();

            stage.getIcons().add(img);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();

            // Close the current Stage
            Stage currentStage = (Stage) btn.getScene().getWindow();
            currentStage.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

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

