package model;

public class Exam {
    private int examId;
    private String exameDescription;
    private int consultId;

    public Exam() {
    }

    public Exam(int examId, String exameDescription, int consultId) {
        this.examId = examId;
        this.exameDescription = exameDescription;
        this.consultId = consultId;
    }

    public int getExamId() {
        return examId;
    }

    public String getExameDescription() {
        return exameDescription;
    }

    public int getConsultId() {
        return consultId;
    }
    
    public void setExameDescription(String exameDescription) {
        this.exameDescription = exameDescription;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    @Override
    public String toString() {
        return "Exam{" + "examId=" + examId + ", exameDescription=" + exameDescription + ", consultId=" + consultId + '}';
    }
    
}
