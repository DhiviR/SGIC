package classes;

public class User {

    private int id;
    private String name;
    private int grade;
    private int age;
    private String gender;
    private String address;
    private String telephone;

    public User(String name, int grade, int age, String gender, String address, String telephone) {
	super();
	this.name = name;
	this.grade = grade;
	this.age = age;
	this.gender = gender;
	this.address = address;
	this.telephone = telephone;
    }

    public User(int id, String name, int grade, int age, String gender, String address, String telephone) {
	super();
	this.id = id;
	this.name = name;
	this.grade = grade;
	this.age = age;
	this.gender = gender;
	this.address = address;
	this.telephone = telephone;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
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
