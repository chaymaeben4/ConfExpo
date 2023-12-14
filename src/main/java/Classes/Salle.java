package Classes;

public class Salle {
    private int Id_salle;
    private String libelle;
    private int capacite;
    private boolean reserve;
    private Session session;
    public Salle(int id_salle, String libelle, int capacite, boolean reserve, Session session) {
        this.Id_salle = id_salle;
        this.libelle = libelle;
        this.capacite = capacite;
        this.reserve = reserve;
        this.session = session;
    }

    // Getter pour Id_salle
    public int getId_salle() {
        return Id_salle;
    }

    // Setter pour Id_salle
    public void setId_salle(int id_salle) {
        Id_salle = id_salle;
    }

    // Getter pour libelle
    public String getLibelle() {
        return libelle;
    }

    // Setter pour libelle
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    // Getter pour capacite
    public int getCapacite() {
        return capacite;
    }

    // Setter pour capacite
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    // Getter pour reserve
    public boolean isReserve() {
        return reserve;
    }

    // Setter pour reserve
    public void setReserve(boolean reserve) {
        this.reserve = reserve;
    }

    // Getter pour session
    public Session getSession() {
        return session;
    }

    // Setter pour session
    public void setSession(Session session) {
        this.session = session;
    }


}
