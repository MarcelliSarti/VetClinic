package view;

import java.util.List;
import java.util.ArrayList;
import model.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

 public class ConsultTableModel extends GenericTableModel{
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     
    public ConsultTableModel(List vDados){
        super(vDados, new String[]{"Data", "Hora", "Histórico", "Cliente", "Animal", "Veterinário", "Exame", "Finalizado"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0 -> {
                return String.class;
            }
            case 1 -> {
                return Integer.class;
            }
            case 2 -> {
                return String.class;
            }
            case 3 -> {
                return String.class;
            }
            case 4 -> {
                return String.class;
            }
            case 5 -> {
                return String.class;
            }
            case 6 -> {
                return List.class;
            }
            case 7 -> {
                return Boolean.class;
            }
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consult consult = (Consult) vDados.get(rowIndex);
        
        switch (columnIndex){
            case 0 -> {
                return dateFormat.format(consult.getConsultDate().getTime());
            }
            case 1 -> {
                return consult.getConsultTime();
            }
            case 2 -> {
                return consult.getConsultHistoric();
            }
            case 3 -> {
                return consult.getAnimal().getClient().getClientName();
            }
            case 4 -> {
                return consult.getAnimal().getAnimalName();
            }
            case 5 -> {
                return consult.getVet().getVetName();
            }
            case 6 -> {
                List<Exam> exams = ExamDAO.getInstance().retrieveByConsult(consult.getConsultId());
                if (exams.isEmpty()){
                    return "";
                }
                var examDescriptionList = new ArrayList<String>();
                for (Exam examDescription: exams) {
                    examDescriptionList.add(examDescription.getExamDescription());
                }
                return examDescriptionList;
            }
            case 7 -> {
                return consult.isConsultFinish();
            }
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Consult consult = (Consult) vDados.get(rowIndex);
        
        switch (columnIndex){
            case 0 -> {
                Calendar cal = Calendar.getInstance();
                try{
                    cal.setTime(dateFormat.parse((String) aValue));
                } catch (ParseException ex){
                    Logger.getLogger(ConsultTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                consult.setConsultDate(cal);
                break;
            }
            case 1 -> {
                consult.setConsultTime((Integer) aValue);
                break;
            }
            case 2 -> {
                consult.setConsultHistoric((String) aValue);
                break;
            }
            case 3 -> {
                break;
            }
            case 4 -> {
                break;
            }
            case 5 -> {
                break;
            }
            case 6 -> {
                break;
            }
            case 7 -> {
                consult.setConsultFinish((Boolean) aValue);
                break;
            }
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        ConsultDAO.getInstance().update(consult);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        if ((columnIndex > 2) && (columnIndex < 7)) {
            return false;
        } else {
            return true;
        }
    }
}
