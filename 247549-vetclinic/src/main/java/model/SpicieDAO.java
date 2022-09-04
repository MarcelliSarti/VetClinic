package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.DAO.getConnection;

public class SpicieDAO extends DAO {
    private static SpicieDAO instance;
    
    private SpicieDAO(){
        getConnection();
        createTable();
    }
    
    public static SpicieDAO getInstance(){
        return (instance==null?(instance = new SpicieDAO()):instance);
    }
    
    public Spicie create(String name){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO spicie (name) VALUES (?)");
            stmt.setString(1, name);
            executeUpdate(stmt);
        } catch (SQLException ex){
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("spicie", "id"));
    };

    public Spicie buildingObject(ResultSet rs){
        Spicie spicie = null;
        try {
            spicie = new Spicie(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return spicie;
    }
    
    public List retrieve(String query){
        List<Spicie> spicies = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()){
                spicies.add(buildingObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return spicies;
    };
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM spicie");
    }
    
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM spicie WHERE id = " + lastId("spicie", "id"));
    }
    
    public Spicie retrieveById(int id){
        List<Spicie> spicie = this.retrieve("SELECT * FROM spicie WHERE id = " + id);
        return (spicie.isEmpty()?null:spicie.get(0));
    };
    
    public List retrieveBySimilarName(String name){
        return this.retrieve("SELECT * FROM spicie WHERE name LIKE '%" + name + "%'");
    }
    
    public void update(int id, String name){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE spicie set name=? where id=?");
            stmt.setString(1, name);
            stmt.setInt(2, id);
            executeUpdate(stmt);
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    };
    
    public void delete(int id){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("DELETE FROM spicie where id=?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    };
}
