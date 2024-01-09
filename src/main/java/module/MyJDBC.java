package module;
import Classes.*;
import com.example.design.ConnectController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.design.ConnectController.getTableName;

public class MyJDBC {
    private static Connection connection;
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


    public static Organisateur checkCredentials_org(String username, String password, String selectedRole) {
          // Accéder à la connexion de la classe MyJDBC
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Organisateur organisateur = null;

        try {
            // Prépare la requête SQL pour sélectionner un organisateur avec le nom d'utilisateur et le mot de passe fournis
            String tableName = getTableName(selectedRole);
            System.out.println(tableName);
            String sql = "SELECT * FROM " + tableName + " WHERE email_organisateur = ? AND mdp_org = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Exécute la requête
            resultSet = preparedStatement.executeQuery();

            // Si un organisateur avec les informations d'identification fournies existe, crée un objet Organisateur
            if (resultSet.next()) {
                organisateur = new Organisateur(
                        resultSet.getInt("id_org"),
                        resultSet.getString("nom_org"),
                        resultSet.getString("prenom_org"),
                        resultSet.getString("email_organisateur"),
                        resultSet.getString("mdp_org")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            myJDBC.closeConnection(preparedStatement, resultSet);  // Appeler la méthode closeConnection de la classe MyJDBC
        }
        return organisateur;
    }
    public static Conferencier checkCredentials_conf(String username, String password, String selectedRole) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Conferencier conferencier = null;

        try {
            // Prepare SQL query to select a user with the given username, password, and role
            String tableName = getTableName(selectedRole);
            String sql = "SELECT * FROM " + tableName + " WHERE email_conferencier = ? AND mdp_conferencier = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // If a user with the given credentials exists, create a Conferencier object
            if (resultSet.next()) {
                conferencier = new Conferencier(
                        resultSet.getInt("id_conferencier"),
                        resultSet.getString("nom_conferencier"),
                        resultSet.getString("prenom_conferencier"),
                        resultSet.getString("email_conferencier"),
                        resultSet.getString("mdp_conferencier")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            connection.closeConnection(connection, preparedStatement, resultSet);
        }
        return conferencier;
    }

    public static Participant checkCredentials_part(String username, String password, String selectedRole) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Participant participant = null;

        try {
            // Prepare SQL query to select a participant with the given username and password
            String tableName = getTableName(selectedRole);
            String sql = "SELECT * FROM " + tableName + " WHERE email_participant = ? AND mdp_participant = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // If a participant with the given credentials exists, create a Participant object
            if (resultSet.next()) {
                participant = new Participant(
                        resultSet.getInt("id_participant"),
                        resultSet.getString("nom_participant"),
                        resultSet.getString("prenom_participant"),
                        resultSet.getString("email_participant"),
                        resultSet.getString("mdp_participant")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            myJDBC.closeConnection(connection, preparedStatement, resultSet);
        }
        return participant;
    }

    public static boolean checkIfUserExists(String username, String selectedRole) {
        try {
            String tableName = getTableName(selectedRole);
            String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE email_" + selectedRole.toLowerCase() + " = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next() && resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String[] getFullNameconf(String username) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            String query = "SELECT nom_conferencier, prenom_conferencier FROM conferencier WHERE email_conferencier = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nom = resultSet.getString("nom_conferencier");
                String prenom = resultSet.getString("prenom_conferencier");
                return new String[]{nom, prenom};
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermez les ressources (ResultSet, PreparedStatement, Connection)
            closeResources(resultSet, preparedStatement, connection);
        }

        return null; // Retourne null si aucune correspondance trouvée
    }
    public String[] getFullNameorg(String username) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            String query = "SELECT nom_org, prenom_org FROM organisateur WHERE email_organisateur = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nom = resultSet.getString("nom_org");
                String prenom = resultSet.getString("prenom_org");
                return new String[]{nom, prenom};
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermez les ressources (ResultSet, PreparedStatement, Connection)
            closeResources(resultSet, preparedStatement, connection);
        }

        return null; // Retourne null si aucune correspondance trouvée
    }
    public String[] getFullNamepart(String username) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            String query = "SELECT nom_participant, prenom_participant FROM participant WHERE email_participant = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nom = resultSet.getString("nom_participant");
                String prenom = resultSet.getString("prenom_participant");
                return new String[]{nom, prenom};
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermez les ressources (ResultSet, PreparedStatement, Connection)
            closeResources(resultSet, preparedStatement, connection);
        }

        return null; // Retourne null si aucune correspondance trouvée
    }
    private void closeResources(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Conference> getCardInformation() {
        List<Conference> conferenceList = new ArrayList<>();

        try {
            String req = "SELECT c.theme, c.date,c.lieu, s.sous_theme, s.horaire , nom_conferencier,prenom_conferencier\n" +
                    "FROM conference c , session s ,conferencier con\n" +
                    "Where c.id=s.id_conference AND con.id_ses=s.id_session";
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();


            while(rs.next()) {
                Conference conference = new Conference(rs.getString("theme"), rs.getDate("date"), rs.getString("lieu"));
                Conferencier c1 = new Conferencier(rs.getString("nom_conferencier"), rs.getString("prenom_conferencier") );
                Session s1 = new Session(rs.getString("sous_theme"), rs.getTime("horaire"), c1);
                conference.setSession1(s1);
                for(int i=2;i<5 && rs.next();i++){
                    Conferencier c = new Conferencier(rs.getString("nom_conferencier"),rs.getString("prenom_conferencier") );
                    Session s = new Session(rs.getString("sous_theme"), rs.getTime("horaire"), c);
                    Method setSessionMethod = Conference.class.getMethod("setSession" + i, Session.class);
                    setSessionMethod.invoke(conference, s);
                }
                conferenceList.add(conference);
            }


        }catch(SQLException | InvocationTargetException E){
            E.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("erreur");
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return conferenceList;
    }

    //participant
    public int getCapaciteBySessionId(int idSession) {
        try {
            String query = "SELECT capacite FROM salle WHERE id_session = ?\n";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idSession);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("capacite");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void decrementerCapaciteSalle(int idSession) {
        try {
            // Obtenez la capacité actuelle de la salle
            int capaciteActuelle = getCapaciteBySessionId(idSession);

            if (capaciteActuelle > 0) {
                // Décrémentez la capacité de la salle
                String query = "UPDATE salle SET capacite = capacite - 1 WHERE id_session = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, idSession);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Capacité décrémentée avec succès pour la session ");
                } else {
                    System.out.println("Aucune mise à jour effectuée. La capacité peut déjà être à son minimum.");
                }
            } else {
                System.out.println("La capacité actuelle est déjà à son minimum pour la session avec l'ID " + idSession);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





}



