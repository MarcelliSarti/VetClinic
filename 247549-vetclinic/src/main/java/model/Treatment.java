package model;

import java.util.Date;

public class Treatment {
    private int treatmentId;
    private Date treatmentBegin;
    private Date treatmentEnd;
    private Integer animalId;

    public Treatment() {
    }
    
    public Treatment(int treatmentId, Date treatmentBegin, Date treatmentEnd, int animalId) {
        this.treatmentId = treatmentId;
        this.treatmentBegin = treatmentBegin;
        this.treatmentEnd = treatmentEnd;
        this.animalId = animalId;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public Date getTreatmentBegin() {
        return treatmentBegin;
    }

    public Date getTreatmentEnd() {
        return treatmentEnd;
    }

    public Integer getAnimalId() {
        return animalId;
    }
    
    public void setTreatmentBegin(Date treatmentBegin) {
        this.treatmentBegin = treatmentBegin;
    }

    public void setTreatmentEnd(Date treatmentEnd) {
        this.treatmentEnd = treatmentEnd;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    @Override
    public String toString() {
        return "Treatment{" + "treatmentId=" + treatmentId + ", treatmentBegin=" + treatmentBegin + ", treatmentEnd=" + treatmentEnd + ", animalId=" + animalId + '}';
    }
    
    
}
