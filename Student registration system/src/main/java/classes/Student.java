package classes;

public class Student {

    private int studentId;
    private String name;
    private int grade;
    private int age;
    private String gender;
    private String address;
    private String telephone;

    public Student(String name, int grade, int age, String gender, String address, String telephone) {
	this.name = name;
	this.grade = grade;
	this.age = age;
	this.gender = gender;
	this.address = address;
	this.telephone = telephone;
    }

    public Student(int studentId, String name, int grade, int age, String gender, String address, String telephone) {
	this.studentId = studentId;
	this.name = name;
	this.grade = grade;
	this.age = age;
	this.gender = gender;
	this.address = address;
	this.telephone = telephone;
    }

    public int getStudentId() {
	return studentId;
    }

    public void setId(int studentId) {
	this.studentId = studentId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getGrade() {
	return grade;
    }

    public void setGrade(int grade) {
	this.grade = grade;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public String getGender() {
	return gender;
    }

    public void setGender(String gender) {
	this.gender = gender;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getTelephone() {
	return telephone;
    }

    public void setTelephone(String telephone) {
	this.telephone = telephone;
    }

}
