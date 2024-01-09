package com.example.design;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class ChoixController {

    @FXML
    private Button btn_conferencier;
    @FXML
    private Button btn_org;
    @FXML
    private Button btn_part;
    public String selectedRole; //pour stocker le choix de l'utilisateur

    @FXML
    public void handleConferencierButton() {
        HelloController helloController =new HelloController();
        ApplicationController.getInstance().setSelectedRole("Conferencier");
        helloController.afficher_page("connect","Page de Connexion", btn_conferencier);
    }

    @FXML
    private void handleOrganisateurButton() {
        HelloController helloController =new HelloController();
        ApplicationController.getInstance().setSelectedRole("Organisateur");
        helloController.afficher_page("connect","Page de Connexion", btn_org);
    }

    @FXML
    private void handleParticipantButton() {
        HelloController helloController =new HelloController();
        ApplicationController.getInstance().setSelectedRole("Participant");
        helloController.afficher_page("connect","Page de Connexion", btn_part);
    }


}
