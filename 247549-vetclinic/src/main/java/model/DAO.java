package model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DAO {
    public static final String DBURL = "jdbc:sqlite:vet.db";
    private static Connection con;
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    //Conect to SqlLite
    public static Connection getConnection(){
        if (con == null){
            try {
                con = DriverManager.getConnection(DBURL);
                if (con != null) {
                    DatabaseMetaData meta = con.getMetaData();
                }
            } catch (SQLException e){
                System.err.println("Exception: " + e.getMessage());
            }
        }
        return con;
    }
    
    protected ResultSet getResultSet(String query){
        Statement s;
        ResultSet rs = null;
        try {
            s = (Statement) con.createStatement();
            rs = s.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return rs;
    }
    
    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException{  
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }
    
    protected int lastId(String tableName, String primaryKey){
        Statement s;
        int lastId = -1;
        try {
            s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(" + primaryKey + ") as id FROM " + tableName);;
            if (rs.next()){
                lastId = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return lastId;
    }
    
    // Create table SqlLite
    protected final boolean createTable(){
        try {
            PreparedStatement stmt;
            // stmt = DAO.getConnection().prepareStatement("DROP TABLE animal;");
            // executeUpdate(stmt);
            // Client Table
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS client (\n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "name VARCHAR, \n"
                    + "cpf VARCHAR, \n"
                    + "adress VARCHAR, \n"
                    + "phone VARCHAR, \n"
                    + "cep VARCHAR, \n"
                    + "email VARCHAR); \n"
            );
            executeUpdate(stmt);
            // Spicie Table
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS spicie (\n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "name VARCHAR); \n"
            );
            executeUpdate(stmt);
            // Animal Table
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS animal (\n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "name VARCHAR, \n"
                    + "cpf VARCHAR, \n"
                    + "ano_nasc INTEGER, \n"
                    + "sex CHAR, \n"
                    + "id_client INTEGER, \n"
                    + "id_spicie INTEGER); \n"
            );
            executeUpdate(stmt);
            // Vet Table
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS vet (\n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "name VARCHAR, \n"
                    + "cpf VARCHAR, \n"
                    + "adress VARCHAR, \n"
                    + "phone VARCHAR, \n"
                    + "cep VARCHAR, \n"
                    + "email VARCHAR); \n"
            );
            executeUpdate(stmt);
            // Treatement Table
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS treatment (\n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "begin DATE, \n"
                    + "end DATE); \n"
            );
            executeUpdate(stmt);
            // Consult Table
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS consult (\n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "consult_date DATE, \n"
                    + "historic VARCHAR); \n"
            );
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return true;
    }
    
    public static void Terminar(){
        try {
            (DAO.getConnection()).close();
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
