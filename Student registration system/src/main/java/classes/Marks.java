package classes;

public class Marks {
    private String marksId;
    private int studentId;
    private int examId;
    private int marks;

    public Marks(String marksId, int studentId, int examId, int marks) {
	super();
	this.marksId = marksId;
	this.studentId = studentId;
	this.examId = examId;
	this.marks = marks;
    }

    public String getMarksId() {
	return marksId;
    }

    public void setMarksId(String marksId) {
	this.marksId = marksId;
    }

    public int getStudentId() {
	return studentId;
    }

    public void setStudentId(int studentId) {
	this.studentId = studentId;
    }

    public int getExamId() {
	return examId;
    }

    public void setExamId(int examId) {
	this.examId = examId;
    }

    public int getMarks() {
	return marks;
    }

    public void setMarks(int marks) {
	this.marks = marks;
    }

}
