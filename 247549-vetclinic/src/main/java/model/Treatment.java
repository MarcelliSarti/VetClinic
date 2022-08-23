package model;

import java.util.Date;

public class Treatment {
    private int treatmentId;
    private Date treatmentBegin;
    private Date treatmentEnd;

    public Treatment() {
    }
    
    public Treatment(int treatmentId, Date treatmentBegin, Date treatmentEnd) {
        this.treatmentId = treatmentId;
        this.treatmentBegin = treatmentBegin;
        this.treatmentEnd = treatmentEnd;
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

    public void setTreatmentBegin(Date treatmentBegin) {
        this.treatmentBegin = treatmentBegin;
    }

    public void setTreatmentEnd(Date treatmentEnd) {
        this.treatmentEnd = treatmentEnd;
    }
}
