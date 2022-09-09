package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.DAO.getConnection;

public class ExamDAO extends DAO {
  private static ExamDAO instance;
    
    private ExamDAO(){
        getConnection();
        createTable();
    }
    
    public static ExamDAO getInstance(){
        return (instance==null?(instance = new ExamDAO()):instance);
    }
    
    public Exam create(String description, int consultId){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO exam (description, id_consult) VALUES (?, ?)");
            stmt.setString(1, description);
            stmt.setInt(2, consultId);
            executeUpdate(stmt);
        } catch (SQLException ex){
            Logger.getLogger(ExamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("exam", "id"));
    };

    public Exam buildingObject(ResultSet rs){
        Exam exam = null;
        try {
            exam = new Exam(rs.getInt("id"), rs.getString("description"), rs.getInt("id_consult"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return exam;
    }
    
    public List retrieve(String query){
        List<Exam> exams = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()){
                exams.add(buildingObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return exams;
    };
    
    public List retrieveAll(){
        return this.retrieve("SELECT * FROM exam");
    }
    
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM exam WHERE id = " + lastId("exam", "id"));
    }
    
    public Exam retrieveById(int id){
        List<Exam> exams = this.retrieve("SELECT * FROM exam WHERE id = " + id);
        return (exams.isEmpty()?null:exams.get(0));
    };
    
    public List retrieveByConsult(int consultId){
        return this.retrieve("SELECT * FROM exam WHERE id_consult = " + consultId);
    };
    
    public void update(int id, String description, int consultId){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE exam set description=?, id_consult=? where id=?");
            stmt.setString(1, description);
            stmt.setInt(2, consultId);
            stmt.setInt(3, id);
            executeUpdate(stmt);
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    };
    
    public void delete(int id){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("DELETE FROM exam where id=?");
            stmt.setInt(1, id);
            executeUpdate(stmt);
        } catch (SQLException e){
            System.err.println("Exception: " + e.getMessage());
        }
    };  
}
