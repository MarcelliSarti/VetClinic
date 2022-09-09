package model;

import java.util.Date;

public class Consult {
    private int consultId;
    private Date consultDate;
    private String consultHistoric;
    private Integer treatmentId;
    private Integer vetId;

    public Consult() {
    }

    public Consult(int consultId, Date consultDate, String consultHistoric, int treatmentId, int vetId) {
        this.consultId = consultId;
        this.consultDate = consultDate;
        this.consultHistoric = consultHistoric;
        this.treatmentId = treatmentId;
        this.vetId = vetId;
    }

    public int getConsultId() {
        return consultId;
    }

    public Date getConsultDate() {
        return consultDate;
    }

    public String getConsultHistoric() {
        return consultHistoric;
    }

    public Integer getTreatmentId() {
        return treatmentId;
    }

    public Integer getVetId() {
        return vetId;
    }
    
    public void setConsultDate(Date consultDate) {
        this.consultDate = consultDate;
    }

    public void setConsultHistoric(String consultHistoric) {
        this.consultHistoric = consultHistoric;
    }

    public void setTreatmentId(Integer treatmentId) {
        this.treatmentId = treatmentId;
    }

    public void setVetId(Integer vetId) {
        this.vetId = vetId;
    }

    @Override
    public String toString() {
        return "Consult{" + "consultId=" + consultId + ", consultDate=" + consultDate + ", consultHistoric=" + consultHistoric + ", treatmentId=" + treatmentId + ", vetId=" + vetId + '}';
    }
    
}
