package model;

public class Spicie {
    private int specieId;
    private String specieName;
    
    public Spicie() {
    }
    
    public Spicie(int specieId, String specieName) {
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
    
}
