package classes;

public class Marks {
    private String marksId;
    private int studentId;
    private String examId;
    private int marks;

    public Marks(String marksId, int studentId, String examId, int marks) {
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

    public String getExamId() {
	return examId;
    }

    public void setExamId(String examId) {
	this.examId = examId;
    }

    public int getMarks() {
	return marks;
    }

    public void setMarks(int marks) {
	this.marks = marks;
    }

}
