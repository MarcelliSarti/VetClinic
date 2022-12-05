package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.DAO.getConnection;

public class SpecieDAO extends DAO {
    private static SpecieDAO instance;
    
    private SpecieDAO(){
        getConnection();
        createTable();
    }
    
    public static SpecieDAO getInstance(){
        return (instance==null?(instance = new SpecieDAO()):instance);
    }
    
    public Specie create(String name){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO specie (name) VALUES (?)");
            stmt.setString(1, name);
            executeUpdate(stmt);
        } catch (SQLException ex){
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("specie", "id"));
    };

    public Specie buildingObject(ResultSet rs){
        Specie specie = null;
        try {
            specie = new Specie(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return specie;
    }
    
    public List retrieve(String query){
        List<Specie> species = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()){
                species.add(buildingObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return species;
    };
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM specie");
    }
    
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM specie WHERE id = " + lastId("specie", "id"));
    }
    
    public Specie retrieveById(int id){
        List<Specie> specie = this.retrieve("SELECT * FROM specie WHERE id = " + id);
        return (specie.isEmpty()?null:specie.get(0));
    };
    
    public List retrieveBySimilarName(String name){
        return this.retrieve("SELECT * FROM specie WHERE name LIKE '%" + name + "%'");
    }
    
    public void update(Specie specie){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE specie set name=? where id=?");
            stmt.setString(1, specie.getSpecieName());
            stmt.setInt(2, specie.getSpecieId());
            executeUpdate(stmt);
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    };
    
    public void delete(int id){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("DELETE FROM specie where id=?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    };
}
