package module;
import Classes.Conferencier;
import Classes.Session;

import java.sql.*;

public class MyJDBC {
    private Connection connection;
    public MyJDBC(){
        try {
            connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/confexpo","root","87467942");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public Conferencier getConferencierInformation(){
        try {
            Statement statement=this.connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT\n" +
                    "    c.id_conferencier,\n" +
                    "    c.nom_conferencier,\n" +
                    "    c.prenom_conferencier,\n" +
                    "    s.id_session,\n" +
                    "    s.sous_theme,\n" +
                    "    s.date_session,\n" +
                    "    s.horaire,\n" +
                    "    cf.lieu\n" +
                    "FROM\n" +
                    "    conferencier c\n" +
                    "INNER JOIN\n" +
                    "    session s ON c.id_ses = s.id_session\n" +
                    "INNER JOIN\n" +
                    "    conference cf ON s.id_conference = cf.id;\n");
            if(resultSet.next()){
                Conferencier conferencier=new Conferencier(resultSet.getInt("id_conferencier"),resultSet.getString("nom_conferencier"),resultSet.getString("prenom_conferencier"),null,null);
                Session session1=new Session(resultSet.getInt("id_session"),resultSet.getString("sous_theme"),resultSet.getDate("date_session"),resultSet.getTime("horaire"), resultSet.getNString("lieu"));
                conferencier.addSession(session1);
                while (resultSet.next()){
                    Session session=new Session(resultSet.getInt("id_session"),resultSet.getString("sous_theme"),resultSet.getDate("date_session"),resultSet.getTime("horaire"), resultSet.getNString("lieu"));
                    conferencier.addSession(session);
                }
                return conferencier;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }




}
