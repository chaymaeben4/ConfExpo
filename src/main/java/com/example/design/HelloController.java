package com.example.design;

import javafx.scene.text.Font;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {
    @FXML
    private Button connect;
    private Button Assister;
    @FXML
    private TextArea text;
    @FXML
    private TextField search;
    @FXML
    private Button s_inscrire;
    @FXML
    private Button commencer_btn;

    @FXML
    private void initialize() {
        // Charger la police dans le contrôleur
        Font.loadFont(getClass().getResourceAsStream("/path/to/RubikMonoOne-Regular.ttf"), 28.0);
    }
    @FXML
    private void handle_commencer_btn(){
        afficher_page("hello-view","page d'acceuil",commencer_btn);
    }

    @FXML
    private void handle_choix_btn(){
        afficher_page("choix","Votre Role",connect);
    }


    @FXML
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
}
