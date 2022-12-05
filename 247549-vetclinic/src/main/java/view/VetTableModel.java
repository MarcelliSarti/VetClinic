package view;

import java.util.List;
import model.*;

 public class VetTableModel extends GenericTableModel{
    public VetTableModel(List vDados){
        super(vDados, new String[]{"Nome", "CPF", "Endereço", "Telefone", "CEP", "E-mail"});
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
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vet vet = (Vet) vDados.get(rowIndex);
        
        switch (columnIndex){
            case 0 -> {
                return vet.getVetName();
            }
            case 1 -> {
                return vet.getVetCpf();
            }
            case 2 -> {
                return vet.getVetAdress();
            }
            case 3 -> {
                return vet.getVetPhone();
            }
            case 4 -> {
                return vet.getVetCep();
            }
            case 5 -> {
                return vet.getVetEmail();
            }
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Vet vet = (Vet) vDados.get(rowIndex);
        
        switch (columnIndex){
            case 0 -> {
                vet.setVetName((String) aValue);
                break;
            }
            case 1 -> {
                vet.setVetCpf((String) aValue);
                break;
            }
            case 2 -> {
                vet.setVetAdress((String) aValue);
                break;
            }
            case 3 -> {
                vet.setVetPhone((String) aValue);
                break;
            }
            case 4 -> {
                vet.setVetCep((String) aValue);
                break;
            }
            case 5 -> {
                vet.setVetEmail((String) aValue);
                break;
            }
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        VetDAO.getInstance().update(vet);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
}
