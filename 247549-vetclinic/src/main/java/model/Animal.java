package model;

public class Animal {
    private int animalId;
    private String animalName;
    private int animalAnoNascimento;
    private String animalSex;   
    private Client client;    
    private Specie spicie;
    
    public Animal() {
    }

    public Animal(int animalId, String animalName, int animalAnoNascimento, String animalSex, Client client, Specie spicie) {
        this.animalId = animalId;
        this.animalName = animalName;
        this.animalAnoNascimento = animalAnoNascimento;
        this.animalSex = animalSex;
        this.client = client;
        this.spicie = spicie;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Specie getSpicie() {
        return spicie;
    }

    public void setSpicie(Specie spicie) {
        this.spicie = spicie;
    }

    @Override
    public String toString() {
        return "Animal{" + "animalId=" + animalId + ", animalName=" + animalName + ", animalAnoNascimento=" + animalAnoNascimento + ", animalSex=" + animalSex + ", client=" + client + ", spicie=" + spicie + '}';
    }

    
}
