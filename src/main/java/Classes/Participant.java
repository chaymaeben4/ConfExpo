package Classes;

public class Participant {
    private int Id_Participant;
    private String nom;
    private String prenom;
    private String nom_utilisateur;
    private String mot_de_passe;
    public Participant(int id_Participant, String nom, String prenom, String nom_utilisateur, String mot_de_passe) {
        this.Id_Participant = id_Participant;
        this.nom = nom;
        this.prenom = prenom;
        this.nom_utilisateur = nom_utilisateur;
        this.mot_de_passe = mot_de_passe;
    }

    // Getter pour Id_Participant
    public int getId_Participant() {
        return Id_Participant;
    }

    // Setter pour Id_Participant
    public void setId_Participant(int id_Participant) {
        Id_Participant = id_Participant;
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
}
