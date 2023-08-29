package model;

import java.util.Calendar;

public class Consult {
    private int consultId;
    private Calendar consultDate;
    private int consultTime;
    private String consultHistoric;
    private Animal animal;
    private Vet vet;
    private boolean consultFinish;

    public Consult() {
    }

    public Consult(int consultId, Calendar consultDate, int consultTime, String consultHistoric, Animal animal, Vet vet, boolean consultFinish) {
        this.consultId = consultId;
        this.consultDate = consultDate;
        this.consultTime = consultTime;
        this.consultHistoric = consultHistoric;
        this.animal = animal;
        this.vet = vet;
        this.consultFinish = consultFinish;
    }

    public int getConsultId() {
        return consultId;
    }

    public Calendar getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(Calendar consultDate) {
        this.consultDate = consultDate;
    }

    public int getConsultTime() {
        return consultTime;
    }

    public void setConsultTime(int consultTime) {
        this.consultTime = consultTime;
    }

    public String getConsultHistoric() {
        return consultHistoric;
    }

    public void setConsultHistoric(String consultHistoric) {
        this.consultHistoric = consultHistoric;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public boolean isConsultFinish() {
        return consultFinish;
    }

    public void setConsultFinish(boolean consultFinish) {
        this.consultFinish = consultFinish;
    }

    @Override
    public String toString() {
        return "Consult{" + "consultId=" + consultId + ", consultDate=" + consultDate + ", consultTime=" + consultTime + ", consultHistoric=" + consultHistoric + ", animal=" + animal + ", vet=" + vet + ", consultFinish=" + consultFinish + '}';
    }
    
}
