package classes;

public class User {

    private String address;
    private int age;
    private int grade;
    private int id;
    private String name;
    private String gender;
    private String telephone;

    public User(String address, int grade, int age, int id, String name, String gender, String telephone) {
	super();
	this.address = address;
	this.grade = grade;
	this.age = age;
	this.id = id;
	this.name = name;
	this.gender = gender;
	this.telephone = telephone;
    }

    public User(String address, int grade, int age, String name, String gender, String telephone) {
	super();
	this.address = address;
	this.grade = grade;
	this.age = age;
	this.name = name;
	this.gender = gender;
	this.telephone = telephone;
    }

    public String getAddress() {
	return address;
    }

    public int getAge() {
	return age;
    }

    public int getGrade() {
	return grade;
    }

    public int getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public String getGender() {
	return gender;
    }

    public String getTelephone() {
	return telephone;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public void setGrade(int grade) {
	this.grade = grade;
    }

    public void setId(int id) {
	this.id = id;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setGender(String gender) {
	this.gender = gender;
    }

    public void setTelephone(String telephone) {
	this.telephone = telephone;
    }

}
