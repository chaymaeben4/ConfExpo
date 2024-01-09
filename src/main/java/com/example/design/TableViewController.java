package com.example.design;

import Classes.Conference;
import Classes.Conferencier;
import Classes.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import module.MyJDBC;

import java.net.URL;
import java.sql.Time;
import java.util.Date;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {
    @FXML
    private TableView<Session> tableConferencier;
    @FXML
    private TableColumn<Session , String> theme_session;
    @FXML
    private TableColumn<Session , Date> date_session;
    @FXML
    private TableColumn<Session, Time> heure_session;
    @FXML
    private TableColumn<Conference,String> lieu_session;
    @FXML
    private Label Nom_conferencier;
    ObservableList<Session> list;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        theme_session.setCellValueFactory(new PropertyValueFactory<Session,String>("sous_theme"));
        date_session.setCellValueFactory(new PropertyValueFactory<Session,Date>("date_Session"));
        heure_session.setCellValueFactory(new PropertyValueFactory<Session,Time>("heure_Session"));
        lieu_session.setCellValueFactory(new PropertyValueFactory<Conference,String>("lieu_Session"));
        MyJDBC conn=new MyJDBC();
        Conferencier conferencier=conn.getConferencierInformation();
        list= FXCollections.observableArrayList(conferencier.getSessions());
        tableConferencier.setItems(list);
        String username = ApplicationController.getInstance().getUsername();
        String[] fullName = conn.getFullNameconf(username);
        String nomPrenom = fullName[0] + " " + fullName[1];
        Nom_conferencier.setText(nomPrenom);

    }
    public void Deconnecter(ActionEvent e){


    }
}
