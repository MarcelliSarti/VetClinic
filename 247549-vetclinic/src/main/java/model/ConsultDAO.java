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
import java.util.Calendar;


public class ConsultDAO extends DAO {
    private static ConsultDAO instance;
    
    private ConsultDAO(){
        getConnection();
        createTable();
    }
    
    public static ConsultDAO getInstance(){
        return (instance==null?(instance = new ConsultDAO()):instance);
    }
    
    public Consult create(Calendar date, Integer time, String historic, Animal animal, Vet vet, boolean finish){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO consult (consult_date, consult_time, historic, id_animal, id_vet, is_finish) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setDate(1, new Date(date.getTimeInMillis()));
            stmt.setInt(2, time);            
            stmt.setString(4, historic);
            stmt.setInt(4, animal.getAnimalId());                             
            stmt.setInt(5, vet.getVetId());
            stmt.setBoolean(6, finish);
            executeUpdate(stmt);
        } catch (SQLException ex){
            Logger.getLogger(ConsultDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("consult", "id"));
    };

    public Consult buildingObject(ResultSet rs){
        Consult consult = null;
        try {
            Animal animal = AnimalDAO.getInstance().retrieveById(rs.getInt("id_animal"));
            Vet vet = VetDAO.getInstance().retrieveById(rs.getInt("id_vet"));
            
            Calendar dt = Calendar.getInstance();
            dt.setTime(rs.getDate("consult_date"));
            
            consult = new Consult(rs.getInt("id"), dt, rs.getInt("consult_time"), rs.getString("historic"), animal, vet, rs.getBoolean("is_finish"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consult;
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
        return this.retrieve("SELECT * FROM consult order by consult_date, consult_time");
    }
    
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM consult WHERE id = " + lastId("consult", "id"));
    }
    
    public Consult retrieveById(int id){
        List<Consult> consult = this.retrieve("SELECT * FROM consult WHERE id = " + id);
        return (consult.isEmpty()?null:consult.get(0));
    };
    
    public List retrieveByAnimal(int animalId){
        return this.retrieve("SELECT * FROM consult WHERE id_animal = " + animalId + " order by consult_date, consult_time");
    };
    
    public List retrieveByVet(int vetId){
        return this.retrieve("SELECT * FROM consult WHERE id_vet = " + vetId + " order by consult_date, consult_time");
    };
    
    public List retrieveByDate(Date consultDate){
        return this.retrieve("SELECT * FROM consult WHERE consult_date = " + consultDate + " order by consult_time");
    };
    
    public void update(Consult consult){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE consult set consult_date=?, consult_time=?, historic=?, is_finish=? where id=?");
            stmt.setDate(1, new Date(consult.getConsultDate().getTimeInMillis()));            
            stmt.setInt(2, consult.getConsultTime());
            stmt.setString(3, consult.getConsultHistoric());
            stmt.setBoolean(4, consult.isConsultFinish()); 
            stmt.setInt(5, consult.getConsultId());
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
