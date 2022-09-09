package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.DAO.getConnection;

public class VetDAO extends DAO {
    private static VetDAO instance;
    
    private VetDAO(){
        getConnection();
        createTable();
    }
    
    public static VetDAO getInstance(){
        return (instance==null?(instance = new VetDAO()):instance);
    }
    
    public Vet create(String name, String cpf, String adress, String phone, String cep, String email){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO vet (name, cpf, adress, phone, cep, email) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, cpf);
            stmt.setString(3, adress);            
            stmt.setString(4, phone);
            stmt.setString(5, cep);
            stmt.setString(6, email);
            executeUpdate(stmt);
        } catch (SQLException ex){
            Logger.getLogger(VetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("vet", "id"));
    };

    public Vet buildingObject(ResultSet rs){
        Vet vet = null;
        try {
            vet = new Vet(rs.getInt("id"), rs.getString("name"), rs.getString("cpf"), rs.getString("adress"), rs.getString("phone"), rs.getString("cep"), rs.getString("email"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return vet;
    }
    
    public List retrieve(String query){
        List<Vet> vets = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()){
                vets.add(buildingObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return vets;
    };
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM vet");
    }
    
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM vet WHERE id = " + lastId("vet", "id"));
    }
    
    public Vet retrieveById(int id){
        List<Vet> vet = this.retrieve("SELECT * FROM vet WHERE id = " + id);
        return (vet.isEmpty()?null:vet.get(0));
    };
    
    public List retrieveBySimilarName(String name){
        return this.retrieve("SELECT * FROM vet WHERE name LIKE '%" + name + "%'");
    }
    
    public void update(int id, String name, String cpf, String adress, String phone, String cep, String email){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE vet set name=?, cpf=?, adress=?, phone=?, cep=?, email=? where id=?");
            stmt.setString(1, name);
            stmt.setString(2, cpf);
            stmt.setString(3, adress); 
            stmt.setString(4, phone);
            stmt.setString(5, cep);
            stmt.setString(6, email);
            stmt.setInt(7, id);
            executeUpdate(stmt);
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    };
    
    public void delete(int id){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("DELETE FROM vet where id=?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    };
}
