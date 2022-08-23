package model;

public class Exam {
    private int examId;
    private String exameDescription;

    public Exam() {
    }

    public Exam(int examId, String exameDescription) {
        this.examId = examId;
        this.exameDescription = exameDescription;
    }

    public int getExamId() {
        return examId;
    }

    public String getExameDescription() {
        return exameDescription;
    }

    public void setExameDescription(String exameDescription) {
        this.exameDescription = exameDescription;
    }
}
