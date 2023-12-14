package Classes;
import java.util.Date;

public class Conference {
    private int Id_Conference;
    private String theme;
    private Date date;
    private String Lieu;
    private Session session1;
    private Session session2;
    private Session session3;
    private Session session4;
    public Conference(int id_Conference, String theme, Date date, String lieu, Session session1, Session session2, Session session3, Session session4) {
        this.Id_Conference = id_Conference;
        this.theme = theme;
        this.date = date;
        this.Lieu = lieu;
        this.session1 = session1;
        this.session2 = session2;
        this.session3 = session3;
        this.session4 = session4;
    }

    public int getId_Conference() {
        return Id_Conference;
    }

    public String getTheme() {
        return theme;
    }


    public Date getDate() {
        return date;
    }

    public String getLieu() {
        return Lieu;
    }

    public Session getSession1() {
        return session1;
    }

    public Session getSession2() {
        return session2;
    }

    public Session getSession3() {
        return session3;
    }

    public Session getSession4() {
        return session4;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLieu(String lieu) {
        Lieu = lieu;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setSession1(Session session1) {
        this.session1 = session1;
    }

    public void setSession2(Session session2) {
        this.session2 = session2;
    }

    public void setSession3(Session session3) {
        this.session3 = session3;
    }

    public void setSession4(Session session4) {
        this.session4 = session4;
    }

}
