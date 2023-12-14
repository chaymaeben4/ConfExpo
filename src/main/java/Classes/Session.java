package Classes;

import java.util.Date;

public class Session {
    private int Id_Session;
    private String sous_theme;
    private Date date_Session;
    private String heure_Session;
    private String lieu_Session;
    private Conferencier conferencier;
    public Session(int id_Session, String sous_theme, Date date_Session, String heure_Session, String lieu_Session, Conferencier conferencier) {
        this.Id_Session = id_Session;
        this.sous_theme = sous_theme;
        this.date_Session = date_Session;
        this.heure_Session = heure_Session;
        this.lieu_Session = lieu_Session;
        this.conferencier = conferencier;
    }

    // Getter pour Id_Session
    public int getId_Session() {
        return Id_Session;
    }

    // Setter pour Id_Session
    public void setId_Session(int id_Session) {
        Id_Session = id_Session;
    }

    // Getter pour sous_theme
    public String getSous_theme() {
        return sous_theme;
    }

    // Setter pour sous_theme
    public void setSous_theme(String sous_theme) {
        this.sous_theme = sous_theme;
    }

    // Getter pour date_Session
    public Date getDate_Session() {
        return date_Session;
    }

    // Setter pour date_Session
    public void setDate_Session(Date date_Session) {
        this.date_Session = date_Session;
    }

    // Getter pour heure_Session
    public String getHeure_Session() {
        return heure_Session;
    }

    // Setter pour heure_Session
    public void setHeure_Session(String heure_Session) {
        this.heure_Session = heure_Session;
    }

    // Getter pour lieu_Session
    public String getLieu_Session() {
        return lieu_Session;
    }

    // Setter pour lieu_Session
    public void setLieu_Session(String lieu_Session) {
        this.lieu_Session = lieu_Session;
    }

    // Getter pour conferencier
    public Conferencier getConferencier() {
        return conferencier;
    }

    // Setter pour conferencier
    public void setConferencier(Conferencier conferencier) {
        this.conferencier = conferencier;
    }

}
