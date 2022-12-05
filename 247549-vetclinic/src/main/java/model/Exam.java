package model;

public class Exam {
    private int examId;
    private String exameDescription;
    private Consult consult;

    public Exam() {
    }

    public Exam(int examId, String exameDescription, Consult consult) {
        this.examId = examId;
        this.exameDescription = exameDescription;
        this.consult = consult;
    }

    public int getExamId() {
        return examId;
    }

    public String getExamDescription() {
        return exameDescription;
    }

    public void setExamDescription(String exameDescription) {
        this.exameDescription = exameDescription;
    }

    public Consult getConsult() {
        return consult;
    }

    public void setConsult(Consult consult) {
        this.consult = consult;
    }

    @Override
    public String toString() {
        return "Exam{" + "examId=" + examId + ", exameDescription=" + exameDescription + ", consult=" + consult + '}';
    }

}
