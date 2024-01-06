package module;
import Classes.Conferencier;
import Classes.Organisateur;
import Classes.Participant;
import Classes.Session;

import java.sql.*;

public class MyJDBC {
    private Connection connection;
    public MyJDBC(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/confexpo", "root", "Chben97531@@");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
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



    public Conferencier inserer_conferencier(Conferencier conferencier){
        try {
            // Prépare la requête d'insertion avec des paramètres
            String query = "INSERT INTO `confexpo`.`conferencier` "
                    + "(`nom_conferencier`, `prenom_conferencier`, `email_conferencier`, `mdp_conferencier`, `id_ses`) "
                    + "VALUES (?, ?, ?, ?, null)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);

            // Définir les valeurs des paramètres
            preparedStatement.setString(1, conferencier.getNom());
            preparedStatement.setString(2, conferencier.getPrenom());
            preparedStatement.setString(3, conferencier.getNom_utilisateur());
            preparedStatement.setString(4, conferencier.getMot_de_passe());

            // Exécute la requête d'insertion
            int rowsAffected = preparedStatement.executeUpdate();

            // Vérifie si l'insertion a réussi
            if (rowsAffected > 0) {
                System.out.println("Insertion réussie.");
            } else {
                System.out.println("Échec de l'insertion.");
            }

            return conferencier;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Organisateur inserer_organisateur(Organisateur organisateur) {
        try {
            // Prépare la requête d'insertion avec des paramètres
            String query = "INSERT INTO confexpo.organisateur " +
                    "(nom_org, prenom_org, email_org, mdp_org, id_conference) " +
                    "VALUES (?, ?, ?, ?, null)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);

            // Définir les valeurs des paramètres
            preparedStatement.setString(1, organisateur.getNom());
            preparedStatement.setString(2, organisateur.getPrenom());
            preparedStatement.setString(3, organisateur.getNom_utilisateur());
            preparedStatement.setString(4, organisateur.getMot_de_passe());

            // Exécute la requête d'insertion
            int rowsAffected = preparedStatement.executeUpdate();

            // Vérifie si l'insertion a réussi
            if (rowsAffected > 0) {
                System.out.println("Insertion réussie.");
            } else {
                System.out.println("Échec de l'insertion.");
            }

            return organisateur;

        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    public Participant inserer_participant(Participant participant) {
        try {
            // Prépare la requête d'insertion avec des paramètres
            String query = "INSERT INTO confexpo.participant " +
                    "(nom_participant, prenom_participant, email_participant, mdp_participant) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);

            // Définir les valeurs des paramètres
            preparedStatement.setString(1, participant.getNom());
            preparedStatement.setString(2, participant.getPrenom());
            preparedStatement.setString(3, participant.getNom_utilisateur());
            preparedStatement.setString(4, participant.getMot_de_passe());

            // Exécute la requête d'insertion
            int rowsAffected = preparedStatement.executeUpdate();

            // Vérifie si l'insertion a réussi
            if (rowsAffected > 0) {
                System.out.println("Insertion réussie.");
            } else {
                System.out.println("Échec de l'insertion.");
            }


            return participant;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public boolean emailExiste(String email, String table) {
        try {
            String query = "SELECT COUNT(*) FROM confexpo." + table + " WHERE email_" + table + " = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    }



