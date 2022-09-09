package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.DAO.getConnection;
import java.sql.Date;

public class TreatmentDAO extends DAO{
    private static TreatmentDAO instance;
    
    private TreatmentDAO(){
        getConnection();
        createTable();
    }
    
    public static TreatmentDAO getInstance(){
        return (instance==null?(instance = new TreatmentDAO()):instance);
    }
    
    public Treatment create(Date treatmentBegin, Date treatmentEnd, int animalID){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO treatment (begin, end, id_animal) VALUES (?, ?, ?)");
            stmt.setDate(1, treatmentBegin);
            stmt.setDate(2, treatmentEnd);
            stmt.setInt(3, animalID);            
            executeUpdate(stmt);
        } catch (SQLException ex){
            Logger.getLogger(TreatmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("treatment", "id"));
    };

    public Treatment buildingObject(ResultSet rs){
        Treatment treatment = null;
        try {
            treatment = new Treatment(rs.getInt("id"), rs.getDate("begin"), rs.getDate("end"), rs.getInt("id_animal"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return treatment;
    }
    
    public List retrieve(String query){
        List<Treatment> treatments = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()){
                treatments.add(buildingObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return treatments;
    };
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM treatment");
    }
    
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM treatment WHERE id = " + lastId("treatment", "id"));
    }
    
    public Treatment retrieveById(int id){
        List<Treatment> treatment = this.retrieve("SELECT * FROM treatment WHERE id = " + id);
        return (treatment.isEmpty()?null:treatment.get(0));
    };
    
    public List retrieveByAnimal(int id_animal){
        return this.retrieve("SELECT * FROM treatment WHERE id_animal = " + id_animal);
    };
    
    public void update(int id, Date begin, Date end, int animalId){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE treatment set begin=?, end=?, id_animal=? where id=?");
            stmt.setDate(1, begin);
            stmt.setDate(2, end);
            stmt.setInt(3, animalId); 
            stmt.setInt(4, id);
            executeUpdate(stmt);
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    };
    
    public void delete(int id){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("DELETE FROM treatment where id=?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    };
}
