package com.school.student.model;

public class StudentDto {
//    private long studentId;
    private String firstName;
    private String lastName;
    private int grade;
    private String gender;
    private String address;
    private String telephone;

//    public long getStudentId() {
//	return studentId;
//    }
//
//    public void setStudentId(long studentId) {
//	this.studentId = studentId;
//    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public int getGrade() {
	return grade;
    }

    public void setGrade(int grade) {
	this.grade = grade;
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
