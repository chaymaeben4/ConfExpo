package com.example.design;


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
    private void handleConnectButton(ActionEvent event) {
        connect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    // Load the FXML file for the "Connect" page
                    FXMLLoader fxmlLoader = new FXMLLoader(Page1.class.getResource("choix.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 1100, 792);
                    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                    Image img =new Image("C:\\Users\\hp\\Desktop\\my studies\\GI2\\S1\\POO Java\\project\\design\\src\\main\\resources\\images\\logo2.png");
                    Stage stage= new Stage();
                    Stage currentPage=(Stage) connect.getScene().getWindow();
                    stage.getIcons().add(img);
                    stage.setTitle("Page d'Acceuil");
                    stage.setScene(scene);
                    stage.show();

                    // Close the current stage
                    currentPage.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
