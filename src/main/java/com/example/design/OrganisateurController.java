package com.example.design;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import module.MyJDBC;

public class OrganisateurController {

    @FXML
    private Label nom_organisateur;

    @FXML
    private Button ajout_btn;
    @FXML
    private Button edit;


    public void initialize() {
        // Récuperer le nom de l'organisateur depuis ApplicationController
            String username = ApplicationController.getInstance().getUsername();
            MyJDBC conn = new MyJDBC();
            String[] fullName = conn.getFullNameorg(username);
            String nomPrenom = fullName[0] + " " + fullName[1];
            nom_organisateur.setText(nomPrenom);
    }
@FXML
private void handle_ajout_btn(){
        HelloController helloController =new HelloController();
        helloController.afficher_page("formulaire-ajouter","Formulaire d'ajout d'une Conference",ajout_btn);
}

    @FXML
    private void handle_edit_btn(){
        HelloController helloController =new HelloController();
        helloController.afficher_page("formulaire-edit","Formulaire de modification ",edit);
    }

}
