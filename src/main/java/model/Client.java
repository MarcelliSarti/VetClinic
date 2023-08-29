package model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int client_id;
    private String clientName;
    private String clientCpf;
    private String clientAdress;
    private String clientPhone;
    private String clientCep;
    private String clientEmail;
    
    public Client() {
    }

    public Client(int client_id, String clientName, String clientCpf, String clientAdress, String clientPhone, String clientCep, String clientEmail) {
        this.client_id = client_id;
        this.clientName = clientName;
        this.clientCpf = clientCpf;
        this.clientAdress = clientAdress;
        this.clientPhone = clientPhone;
        this.clientCep = clientCep;
        this.clientEmail = clientEmail;
    }

    public int getClientId() {
        return client_id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientCpf() {
        return clientCpf;
    }

    public void setClientCpf(String clientCpf) {
        this.clientCpf = clientCpf;
    }

    public String getClientAdress() {
        return clientAdress;
    }

    public void setClientAdress(String clientAdress) {
        this.clientAdress = clientAdress;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientCep() {
        return clientCep;
    }

    public void setClientCep(String clientCep) {
        this.clientCep = clientCep;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Override
    public String toString() {
        return "Client{" + "client_id=" + client_id + ", clientName=" + clientName + ", clientCpf=" + clientCpf + ", clientAdress=" + clientAdress + ", clientPhone=" + clientPhone + ", clientCep=" + clientCep + ", clientEmail=" + clientEmail + '}';
    }
    
}
