package model;

import java.util.Date;

public class Consult {
    private int consultId;
    private Date consultDate;
    private String consultHistoric;

    public Consult() {
    }

    public Consult(int consultId, Date consultDate, String consultHistoric) {
        this.consultId = consultId;
        this.consultDate = consultDate;
        this.consultHistoric = consultHistoric;
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

    public void setConsultDate(Date consultDate) {
        this.consultDate = consultDate;
    }

    public void setConsultHistoric(String consultHistoric) {
        this.consultHistoric = consultHistoric;
    }
}
