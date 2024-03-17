package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;


public class Connexio {
    private static Connexio instancia = null;
    //private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCLCDB";
    private final String URL = "jdbc:sqlite:database.db";    
    
    public static Connexio getConnexio(){
        if(instancia == null) instancia = new Connexio();
        return instancia;
    }
    private Connexio() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found.");
           // e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
    public PreparedStatement getPrepared(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }   
}
    
