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

public class ConsultDAO extends DAO {
    private static ConsultDAO instance;
    
    private ConsultDAO(){
        getConnection();
        createTable();
    }
    
    public static ConsultDAO getInstance(){
        return (instance==null?(instance = new ConsultDAO()):instance);
    }
    
    public Consult create(Date date, String historic, int treatmentId, int vetId){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO consult (consult_date, historic, id_treatment, id_vet) VALUES (?, ?, ?, ?)");
            stmt.setDate(1, date);
            stmt.setString(2, historic);
            stmt.setInt(3, treatmentId);                             
            stmt.setInt(4, vetId);
            executeUpdate(stmt);
        } catch (SQLException ex){
            Logger.getLogger(ConsultDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("consult", "id"));
    };

    public Consult buildingObject(ResultSet rs){
        Consult conult = null;
        try {
            conult = new Consult(rs.getInt("id"), rs.getDate("consult_date"), rs.getString("historic"), rs.getInt("id_treatment"), rs.getInt("id_vet"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return conult;
    }
    
    public List retrieve(String query){
        List<Consult> consults = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()){
                consults.add(buildingObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consults;
    };
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM consult");
    }
    
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM consult WHERE id = " + lastId("consult", "id"));
    }
    
    public Consult retrieveById(int id){
        List<Consult> consult = this.retrieve("SELECT * FROM consult WHERE id = " + id);
        return (consult.isEmpty()?null:consult.get(0));
    };
    
    public List retrieveByTreatment(int treatmentId){
        return this.retrieve("SELECT * FROM consult WHERE id_treatment = " + treatmentId);
    };
    
    public List retrieveByVet(int vetId){
        return this.retrieve("SELECT * FROM consult WHERE id_vet = " + vetId);
    };
    
    public void update(int id, Date consult_date, String historic, int treatmentId, int vetId){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE consult set consult_date=?, historic=?, id_treatment=?, id_vet=? where id=?");
            stmt.setDate(1, consult_date);
            stmt.setString(2, historic);
            stmt.setInt(3, treatmentId); 
            stmt.setInt(4, vetId); 
            stmt.setInt(5, id);
            executeUpdate(stmt);
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    };
    
    public void delete(int id){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("DELETE FROM consult where id=?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    };
}
