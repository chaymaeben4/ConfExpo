package module;
import java.sql.*;

public class MyJDBC {
    private Connection connection;
    public MyJDBC(){
        try {
            connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/confexpo","root","Chben97531@@");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void get(){
        try {
            Statement statement=this.connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM salle");
            while (resultSet.next()){
                System.out.println(resultSet.getString("libelle"));
            }
        }catch(SQLException e){
            e.printStackTrace();

        }

    }




}
