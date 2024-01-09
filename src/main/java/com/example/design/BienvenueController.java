package com.example.design;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BienvenueController {
    @FXML
    private Button commencer_btn;

    @FXML
    private void handle_commencer_btn(){

        HelloController helloController= new HelloController();
        helloController.afficher_page("hello-view","Page d'acceuil",commencer_btn);
    }
}
