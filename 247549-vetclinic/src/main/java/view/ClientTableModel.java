package view;

import java.util.List;
import model.*;

 public class ClientTableModel extends GenericTableModel{
    public ClientTableModel(List vDados){
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
        Client client = (Client) vDados.get(rowIndex);
        
        switch (columnIndex){
            case 0 -> {
                return client.getClientName();
            }
            case 1 -> {
                return client.getClientCpf();
            }
            case 2 -> {
                return client.getClientAdress();
            }
            case 3 -> {
                return client.getClientPhone();
            }
            case 4 -> {
                return client.getClientCep();
            }
            case 5 -> {
                return client.getClientEmail();
            }
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Client client = (Client) vDados.get(rowIndex);
        
        switch (columnIndex){
            case 0 -> {
                client.setClientName((String) aValue);
                break;
            }
            case 1 -> {
                client.setClientCpf((String) aValue);
                break;
            }
            case 2 -> {
                client.setClientAdress((String) aValue);
                break;
            }
            case 3 -> {
                client.setClientPhone((String) aValue);
                break;
            }
            case 4 -> {
                client.setClientCep((String) aValue);
                break;
            }
            case 5 -> {
                client.setClientEmail((String) aValue);
                break;
            }
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        ClientDAO.getInstance().update(client);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
}
