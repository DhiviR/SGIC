package classes;

public class Exam {
    private int id;
    private int term;
    private int grade;
    private String subjectName;

    public Exam(int term, int grade, String subjectName) {
	super();
	this.term = term;
	this.grade = grade;
	this.subjectName = subjectName;
    }

    public Exam(int id, int term, int grade, String subjectName) {
	super();
	this.id = id;
	this.term = term;
	this.grade = grade;
	this.subjectName = subjectName;
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

    public String getSubjectName() {
	return subjectName;
    }

    public void setSubjectName(String subjectName) {
	this.subjectName = subjectName;
    }
}
