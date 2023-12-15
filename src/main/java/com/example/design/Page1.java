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

        //connectionDB
//        MyJDBC conn=new MyJDBC();
//        Conferencier conferencier=conn.getConferencierInformation();
//        for(Session session: conferencier.getSessions()) {
//
//            System.out.println(session.getLieu_Session());
//
//        }


        FXMLLoader fxmlLoader = new FXMLLoader(Page1.class.getResource("Conferencier.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 1100, 792);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        Image img =new Image("C:\\Users\\pc\\Documents\\s7\\Java\\MonProjet\\frontEnd\\src\\main\\resources\\images\\logo2.png");
        stage.getIcons().add(img);
        stage.setTitle("Page d'Acceuil");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}