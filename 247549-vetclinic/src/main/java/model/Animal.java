package model;

public class Animal {
    private int animalId;
    private String animalName;
    private int animalAnoNascimento;
    private String animalSex;   
    private int idClient;    
    private int idSpicie;
    
    public Animal() {
    }

    public Animal(int animalId, String animalName, int animalAnoNascimento, String animalSex, int idClient, int idSpicie) {
        this.animalId = animalId;
        this.animalName = animalName;
        this.animalAnoNascimento = animalAnoNascimento;
        this.animalSex = animalSex;
        this.idClient = idClient;
        this.idSpicie = idSpicie;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAnimalAnoNascimento() {
        return animalAnoNascimento;
    }

    public void setAnimalAnoNascimento(int animalAnoNascimento) {
        this.animalAnoNascimento = animalAnoNascimento;
    }

    public String getAnimalSex() {
        return animalSex;
    }

    public void setAnimalSex(String animalSex) {
        this.animalSex = animalSex;
    }
    
    public int getIdSpicie() {
        return idSpicie;
    }

    public void seIidSpicie(int idSpicie) {
        this.idSpicie = idSpicie;
    }
    
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "Animal{" + "animalId=" + animalId + ", animalName=" + animalName + ", animalAnoNascimento=" + animalAnoNascimento + ", animalSex=" + animalSex + ", idClient=" + idClient + ", idSpicie=" + idSpicie + '}';
    }
    
}
