package com.example.design;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button connect;
    private Button Assister;
    private TextArea text ;
    @FXML
    private TextField search;


    @FXML
    private void ChangerDePage() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("connect.fxml"));
        Parent page2 = loader.load();

        // Créer une nouvelle scène
        Scene scene2 = new Scene(connect);

        // Obtenir la scène actuelle à partir du bouton
        Stage stage = (Stage) connect.getScene().getWindow();

        // Remplacer la scène actuelle par la nouvelle scène
        stage.setScene(scene2);
    }
}