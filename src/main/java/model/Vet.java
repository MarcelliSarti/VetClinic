package model;

public class Vet {
    private int vetId;
    private String vetName;
    private String vetCpf;
    private String vetAdress;
    private String vetPhone;
    private String vetCep;
    private String vetEmail;

    public Vet() {
    }

    public Vet(int vetId, String vetName, String vetCpf, String vetAdress, String vetPhone, String vetCep, String vetEmail) {
        this.vetId = vetId;
        this.vetName = vetName;
        this.vetCpf = vetCpf;
        this.vetAdress = vetAdress;
        this.vetPhone = vetPhone;
        this.vetCep = vetCep;
        this.vetEmail = vetEmail;
    }

    public int getVetId() {
        return vetId;
    }

    public String getVetName() {
        return vetName;
    }

    public String getVetCpf() {
        return vetCpf;
    }

    public String getVetAdress() {
        return vetAdress;
    }

    public String getVetPhone() {
        return vetPhone;
    }

    public String getVetCep() {
        return vetCep;
    }

    public String getVetEmail() {
        return vetEmail;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public void setVetCpf(String vetCpf) {
        this.vetCpf = vetCpf;
    }

    public void setVetAdress(String vetAdress) {
        this.vetAdress = vetAdress;
    }

    public void setVetPhone(String vetPhone) {
        this.vetPhone = vetPhone;
    }

    public void setVetCep(String vetCep) {
        this.vetCep = vetCep;
    }

    public void setVetEmail(String vetEmail) {
        this.vetEmail = vetEmail;
    }

    @Override
    public String toString() {
        return "Vet{" + "vetId=" + vetId + ", vetName=" + vetName + ", vetCpf=" + vetCpf + ", vetAdress=" + vetAdress + ", vetPhone=" + vetPhone + ", vetCep=" + vetCep + ", vetEmail=" + vetEmail + '}';
    }
    
}
