package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class AnimalDAO extends DAO {
    private static AnimalDAO instance;
    
    private AnimalDAO(){
        getConnection();
        createTable();
    }
    
    public static AnimalDAO getInstance(){
        return (instance==null?(instance = new AnimalDAO()):instance);
    }
    
    public Animal create(String name, int anoNasc, String sex, int idClient, int idSpicie){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO animal (name, ano_nasc, sex, id_client, id_spicie) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, name);
            stmt.setInt(2, anoNasc);
            stmt.setString(3, sex);            
            stmt.setInt(4, idClient);
            stmt.setInt(5, idSpicie);
            executeUpdate(stmt);
        } catch (SQLException ex){
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("animal", "id"));
    };

    public Animal buildingObject(ResultSet rs){
        Animal animal = null;
        try {
            animal = new Animal(rs.getInt("id"), rs.getString("name"), rs.getInt("ano_nasc"), rs.getString("sex"), rs.getInt("id_client"), rs.getInt("id_spicie"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animal;
    }
    
    public List retrieve(String query){
        List<Animal> animals = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()){
                animals.add(buildingObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animals;
    };
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM animal");
    }
    
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM animal WHERE id = " + lastId("animal", "id"));
    }
    
    public Animal retrieveById(int id){
        List<Animal> animals = this.retrieve("SELECT * FROM animal WHERE id = " + id);
        return (animals.isEmpty()?null:animals.get(0));
    };
    
    public List retrieveByClient(int idClient){
        return this.retrieve("SELECT * FROM animal WHERE id_client = " + idClient);
    };
    
    public List retrieveBySimilarName(String name){
        return this.retrieve("SELECT * FROM animal WHERE name LIKE '%" + name + "%'");
    }
    
    public void update(int id, String name, int anoNasc, String sex, int clientId, int spicieId){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE animal set name=?, ano_nasc=?, sex=?, id_client=?, id_spicie=? where id=?");
            stmt.setString(1, name);
            stmt.setInt(2, anoNasc);
            stmt.setString(3, sex);            
            stmt.setInt(4, clientId);
            stmt.setInt(5, spicieId);
            stmt.setInt(6, id);
            executeUpdate(stmt);
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    };
    
    public void delete(int id){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("DELETE FROM animal where id=?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    };
}
