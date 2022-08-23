package model;

public class Animal {
    private int animalId;
    private String animalName;
    private int animalAge;
    private char animalSex;   
    
    public Animal() {
    }

    public Animal(int animalId, String animalName, int animalAge, char animalSex) {
        this.animalId = animalId;
        this.animalName = animalName;
        this.animalAge = animalAge;
        this.animalSex = animalSex;
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

    public int getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }

    public char getAnimalSex() {
        return animalSex;
    }

    public void setAnimalSex(char animalSex) {
        this.animalSex = animalSex;
    }
    
}
