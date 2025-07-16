package server;
import java.sql.*;

public class DBConnection {
    
    Connection con = null;
    
    public DBConnection() throws SQLException{
        
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded successfully");
        }catch(ClassNotFoundException cnfe){
            System.out.println("could not load driver "+cnfe.getMessage());
        }
        
        String path = "jdbc:postgresql://localhost:5432/dealership";
        String username = "postgres";
        String password = "Maverick";
        
        try{
            con = DriverManager.getConnection(path,username,password);
            System.out.println("Connected to database.");
        }catch(SQLException sqle){
            System.out.println("Connection failed " + sqle.getMessage());
        }
    }
    
}