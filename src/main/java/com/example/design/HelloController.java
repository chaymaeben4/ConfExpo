package com.example.design;

import Classes.Conference;
import javafx.scene.control.Label;
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
import module.MyJDBC;

import java.io.IOException;
import java.util.List;


public class HelloController {
    @FXML
    private Button assister;

    @FXML
    private Button connect;
    @FXML
    private Label dateLabel;
    @FXML
    private Label locationLabel;
    @FXML
    private Label themeLabel;
    @FXML
    private Label theme1;
    @FXML
    private Label theme2;
    @FXML
    private Label theme3;
    @FXML
    private Label theme4;
    @FXML
    private Label sessionsLabel;
    @FXML
    private Label Horaire1;
    @FXML
    private Label Horaire2;
    @FXML
    private Label Horaire3;
    @FXML
    private Label Horaire4;
    @FXML
    private Label Conferencier1;
    @FXML
    private Label Conferencier2;
    @FXML
    private Label Conferencier3;
    @FXML
    private Label Conferencier4;
    @FXML
    private Label dateLabel1;
    @FXML
    private Label locationLabel1;
    @FXML
    private Label themeLabel1;
    @FXML
    private Label theme11;
    @FXML
    private Label theme21;
    @FXML
    private Label theme31;
    @FXML
    private Label theme41;
    @FXML
    private Label sessionsLabel1;
    @FXML
    private Label Horaire11;
    @FXML
    private Label Horaire21;
    @FXML
    private Label Horaire31;
    @FXML
    private Label Horaire41;
    @FXML
    private Label Conferencier11;
    @FXML
    private Label Conferencier21;
    @FXML
    private Label Conferencier31;
    @FXML
    private Label Conferencier41;
    @FXML
    private Button commencer_btn;

    @FXML
    private void initialize() {
        Font.loadFont(getClass().getResourceAsStream("/path/to/RubikMonoOne-Regular.ttf"), 28.0);
        MyJDBC DB=new MyJDBC();
        List<Conference> conferences=DB.getCardInformation();
        dateLabel.setText("Date"+conferences.get(0).getDate());
        locationLabel.setText("Lieu:"+conferences.get(0).getLieu());
        themeLabel.setText("Theme:"+conferences.get(0).getTheme());
        theme1.setText("1-"+conferences.get(0).getSession1().getSous_theme());
        theme2.setText("2-"+conferences.get(0).getSession2().getSous_theme());
        theme3.setText("3-"+conferences.get(0).getSession3().getSous_theme());
        theme4.setText("4-"+conferences.get(0).getSession4().getSous_theme());
        Horaire1.setText("Horaire:"+conferences.get(0).getSession1().getHeure_Session());
        Horaire2.setText("Horaire:"+conferences.get(0).getSession2().getHeure_Session());
        Horaire3.setText("Horaire:"+conferences.get(0).getSession3().getHeure_Session());
        Horaire4.setText("Horaire:"+conferences.get(0).getSession4().getHeure_Session());
        Conferencier1.setText("Conferencier :"+conferences.get(0).getSession1().getConferencier().getNom()+" "+conferences.get(0).getSession1().getConferencier().getPrenom());
        Conferencier2.setText("Conferencier :"+conferences.get(0).getSession2().getConferencier().getNom()+" "+conferences.get(0).getSession2().getConferencier().getPrenom());
        Conferencier3.setText("Conferencier :"+conferences.get(0).getSession3().getConferencier().getNom()+" "+conferences.get(0).getSession3().getConferencier().getPrenom());
        Conferencier4.setText("Conferencier :"+conferences.get(0).getSession4().getConferencier().getNom()+" "+conferences.get(0).getSession4().getConferencier().getPrenom());
        dateLabel1.setText("Date"+conferences.get(1).getDate());
        locationLabel1.setText("Lieu:"+conferences.get(1).getLieu());
        themeLabel1.setText("Theme:"+conferences.get(1).getTheme());
        theme11.setText("1-"+conferences.get(1).getSession1().getSous_theme());
        theme21.setText("2-"+conferences.get(1).getSession2().getSous_theme());
        theme31.setText("3-"+conferences.get(1).getSession3().getSous_theme());
        theme41.setText("4-"+conferences.get(1).getSession4().getSous_theme());
        Horaire11.setText("Horaire:"+conferences.get(1).getSession1().getHeure_Session());
        Horaire21.setText("Horaire:"+conferences.get(1).getSession2().getHeure_Session());
        Horaire31.setText("Horaire:"+conferences.get(1).getSession3().getHeure_Session());
        Horaire41.setText("Horaire:"+conferences.get(1).getSession4().getHeure_Session());
        Conferencier11.setText("Conferencier :"+conferences.get(1).getSession1().getConferencier().getNom()+" "+conferences.get(1).getSession1().getConferencier().getPrenom());
        Conferencier21.setText("Conferencier :"+conferences.get(1).getSession2().getConferencier().getNom()+" "+conferences.get(1).getSession2().getConferencier().getPrenom());
        Conferencier31.setText("Conferencier :"+conferences.get(1).getSession3().getConferencier().getNom()+" "+conferences.get(1).getSession3().getConferencier().getPrenom());
        Conferencier41.setText("Conferencier :"+conferences.get(1).getSession4().getConferencier().getNom()+" "+conferences.get(1).getSession4().getConferencier().getPrenom());

    }


    @FXML
    private void handle_choix_btn(){
        afficher_page("choix","Choix du role",connect);
    }
    @FXML
    private void handle_assister_btn(){
        afficher_page("connect","Page de Connexion",assister);
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
