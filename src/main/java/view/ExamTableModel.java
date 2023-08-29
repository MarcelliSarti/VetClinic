package view;

import java.util.List;
import model.*;

 public class ExamTableModel extends GenericTableModel{
    public ExamTableModel(List vDados){
        super(vDados, new String[]{"Descrição", "Consulta"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0 -> {
                return String.class;
            }
            case 1 -> {
                return String.class;
            }
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Exam exam = (Exam) vDados.get(rowIndex);
        
        switch (columnIndex){
            case 0 -> {
                return exam.getExamDescription();
            }
            case 1 -> {
                return exam.getConsult().getConsultId();
            }
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Exam exam = (Exam) vDados.get(rowIndex);
        
        switch (columnIndex){
            case 0 -> {
                exam.setExamDescription((String) aValue);
                break;
            }
            case 1 -> {
                exam.setConsult((Consult) aValue);
                break;
            }
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        ExamDAO.getInstance().update(exam);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
}
