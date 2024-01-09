package com.example.design;

import Classes.Conferencier;
import Classes.Session;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import module.MyJDBC;

public class Page1 extends Application {
    @Override
    public void start(Stage stage) throws IOException {



        FXMLLoader fxmlLoader = new FXMLLoader(Page1.class.getResource("Bienvenue.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 1100, 792);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        Image img = new Image(getClass().getResource("/images/logo2.png").toExternalForm());
        stage.getIcons().add(img);
        stage.setTitle("Bienvenue");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}