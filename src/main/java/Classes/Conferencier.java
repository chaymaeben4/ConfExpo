package Classes;

import java.util.ArrayList;

public class Conferencier {
    private int Id_Conferencier;
    private String nom;
    private String prenom;
    private String nom_utilisateur;
    private String mot_de_passe;
    private ArrayList<Session> sessions;
    public Conferencier(int id_Conferencier, String nom, String prenom, String nom_utilisateur, String mot_de_passe) {
        this.Id_Conferencier = id_Conferencier;
        this.nom = nom;
        this.prenom = prenom;
        this.nom_utilisateur = nom_utilisateur;
        this.mot_de_passe = mot_de_passe;
        sessions=new ArrayList<>();
    }
    public Conferencier(String nom, String prenom, String nom_utilisateur, String mot_de_passe) {

        this.nom = nom;
        this.prenom = prenom;
        this.nom_utilisateur = nom_utilisateur;
        this.mot_de_passe = mot_de_passe;

    }

    public void addSession(Session session){
        this.sessions.add(session);

    }
    // Getter pour Id_Conferencier
    public int getId_Conferencier() {
        return Id_Conferencier;
    }

    // Setter pour Id_Conferencier
    public void setId_Conferencier(int id_Conferencier) {
        Id_Conferencier = id_Conferencier;
    }

    // Getter pour nom
    public String getNom() {
        return nom;
    }

    // Setter pour nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour prenom
    public String getPrenom() {
        return prenom;
    }

    // Setter pour prenom
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Getter pour nom_utilisateur
    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    // Setter pour nom_utilisateur
    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    // Getter pour mot_de_passe
    public String getMot_de_passe() {
        return mot_de_passe;
    }

    // Setter pour mot_de_passe
    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
    public ArrayList<Session> getSessions(){
        return sessions;
    }

}
