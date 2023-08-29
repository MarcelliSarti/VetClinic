package model;

public class Specie {
    private int specieId;
    private String specieName;
    
    public Specie() {
    }
    
    public Specie(int specieId, String specieName) {
        this.specieId = specieId;
        this.specieName = specieName;
    }

    public void setSpecieName(String specieName) {
        this.specieName = specieName;
    }
    
    public int getSpecieId() {
        return specieId;
    }

    public String getSpecieName() {
        return specieName;
    }
    
    @Override
    public String toString() {
        return "Specie{" + "specieId=" + specieId + ", specieName=" + specieName + '}';
    }
}
