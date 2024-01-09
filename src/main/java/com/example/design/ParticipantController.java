package com.example.design;

import Classes.Conference;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.LinearGradient;
import javafx.scene.text.Font;
import module.MyJDBC;

import java.util.List;

public class ParticipantController {

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
    private CheckBox check11;

    @FXML
    private CheckBox check12;

    @FXML
    private CheckBox check13;

    @FXML
    private CheckBox check14;
    @FXML
    private CheckBox check21;

    @FXML
    private CheckBox check22;

    @FXML
    private CheckBox check23;

    @FXML
    private CheckBox check24;

    @FXML
    private Label nom_participant;


    private int idSession1=3;
    private int idSession2=18;
    private int idSession3=20;
    private int idSession4=4;
    private boolean isAlertDisplayed;

    @FXML
    private void onAssisterButtonClicked() {
        String msg="";
        if (check11.isSelected()) {
            msg+=handleAssisterForSession(idSession1,msg)+"1\n";
        }
        if (check12.isSelected()) {

            msg+=handleAssisterForSession(idSession2,msg)+"2\n";
        }
        if (check13.isSelected()) {
            msg+=handleAssisterForSession(idSession3,msg)+"3\n";
        }
        if (check14.isSelected()) {
            msg+=handleAssisterForSession(idSession4,msg)+"4\n";
        }

        showAlert(msg==""?"veuiller choisir vos session d'abord":msg);
    }

    private String handleAssisterForSession(int sessionId, String msg) {
        MyJDBC myJDBC = new MyJDBC();

        // Obtenez la capacité actuelle de la salle
        int capacite = myJDBC.getCapaciteBySessionId(sessionId);

        if (capacite <= 0) {
            return "la salle est sature pour la session ";
        } else {
            // Décrémentez la capacité de la salle
            myJDBC.decrementerCapaciteSalle(sessionId);

            return  "inscription reussite à la session ";
        }
    }


    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message de confirmation");
        alert.setHeaderText(null);
        alert.setContentText(message);
        DialogPane dialogPane = alert.getDialogPane();
        alert.showAndWait();
    }

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
            String username = ApplicationController.getInstance().getUsername();

            String[] fullName = DB.getFullNamepart(username);
            String nomPrenom = fullName[0] + " " + fullName[1];
            this.nom_participant.setText(nomPrenom);
        }




}

