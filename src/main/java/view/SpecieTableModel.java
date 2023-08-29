package view;

import java.util.List;
import model.*;

 public class SpecieTableModel extends GenericTableModel{
    public SpecieTableModel(List vDados){
        super(vDados, new String[]{"Nome"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0 -> {
                return String.class;
            }
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Specie spicie = (Specie) vDados.get(rowIndex);
        
        switch (columnIndex){
            case 0 -> {
                return spicie.getSpecieName();
            }
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Specie spicie = (Specie) vDados.get(rowIndex);
        
        switch (columnIndex){
            case 0 -> {
                spicie.setSpecieName((String) aValue);
                break;
            }
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        SpecieDAO.getInstance().update(spicie);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
}
