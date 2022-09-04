package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.DAO.getConnection;

public class ClientDAO extends DAO {
    private static ClientDAO instance;
    
    private ClientDAO(){
        getConnection();
        createTable();
    }
    
    public static ClientDAO getInstance(){
        return (instance==null?(instance = new ClientDAO()):instance);
    }
    
    public Client create(String name, String cpf, String adress, String phone, String cep, String email){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO client (name, cpf, adress, phone, cep, email) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, cpf);
            stmt.setString(3, adress);            
            stmt.setString(4, phone);
            stmt.setString(5, cep);
            stmt.setString(6, email);
            executeUpdate(stmt);
        } catch (SQLException ex){
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("client", "id"));
    };

    public Client buildingObject(ResultSet rs){
        Client client = null;
        try {
            client = new Client(rs.getInt("id"), rs.getString("name"), rs.getString("cpf"), rs.getString("adress"), rs.getString("phone"), rs.getString("cep"), rs.getString("email"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return client;
    }
    
    public List retrieve(String query){
        List<Client> clients = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()){
                clients.add(buildingObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return clients;
    };
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM client");
    }
    
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM client WHERE id = " + lastId("client", "id"));
    }
    
    public Client retrieveById(int id){
        List<Client> client = this.retrieve("SELECT * FROM client WHERE id = " + id);
        return (client.isEmpty()?null:client.get(0));
    };
    
    public List retrieveBySimilarName(String name){
        return this.retrieve("SELECT * FROM client WHERE name LIKE '%" + name + "%'");
    }
    
    public void update(int id, String name, String cpf, String adress, String phone, String cep, String email){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE client set name=?, cpf=?, adress=?, phone=?, cep=?, email=? where id=?");
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
            stmt = DAO.getConnection().prepareStatement("DELETE FROM animal where id=?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    };
}
