package view;

import java.util.List;
import model.*;

 public class AnimalTableModel extends GenericTableModel{
    public AnimalTableModel(List vDados){
        super(vDados, new String[]{"Nome", "AnoNascimento", "Sexo", "Cliente", "Espécie"});
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
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);
        
        switch (columnIndex){
            case 0 -> {
                return animal.getAnimalName();
            }
            case 1 -> {
                return animal.getAnimalAnoNascimento();
            }
            case 2 -> {
                return animal.getAnimalSex();
            }
            case 3 -> {
                return animal.getClient().getClientName();
            }
            case 4 -> {
                return animal.getSpicie().getSpecieName();
            }
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);
        
        switch (columnIndex){
            case 0 -> {
                animal.setAnimalName((String) aValue);
                break;
            }
            case 1 -> {
                animal.setAnimalAnoNascimento((int) aValue);
                break;
            }
            case 2 -> {
                animal.setAnimalSex((String) aValue);
                break;
            }
            case 3 -> {
                break;
            }
            case 4 -> {
                break;
            }
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        AnimalDAO.getInstance().update(animal);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        if (columnIndex > 2) {
            return false;
        } else {
            return true;
        }
    }
}
