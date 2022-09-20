package classes;

public class Exam {
    private int id;
    private int term;
    private int grade;
    private String subject;

    public Exam(int term, int grade, String subject) {
	super();
	this.term = term;
	this.grade = grade;
	this.subject = subject;
    }

    public Exam(int id, int term, int grade, String subject) {
	super();
	this.id = id;
	this.term = term;
	this.grade = grade;
	this.subject = subject;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
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
