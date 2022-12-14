package classes;

public class Exam {
    private String examId;
    private int term;
    private int grade;
    private String subject;

    public Exam(int term, int grade, String subject) {
	super();
	this.term = term;
	this.grade = grade;
	this.subject = subject;
    }

    public Exam(String examId, int term, int grade, String subject) {
	super();
	this.examId = examId;
	this.term = term;
	this.grade = grade;
	this.subject = subject;
    }

    public String getExamId() {
	return examId;
    }

    public void setExamId(String examId) {
	this.examId = examId;
    }

    public int getTerm() {
	return term;
    }

    public void setTerm(int term) {
	this.term = term;
    }

    public int getGrade() {
	return grade;
    }

    public void setGrade(int grade) {
	this.grade = grade;
    }

    public String getSubject() {
	return subject;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }
}
