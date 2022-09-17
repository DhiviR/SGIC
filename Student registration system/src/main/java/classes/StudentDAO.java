package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/student_registration_system?useSSL=false";
    private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_STUDENT = "INSERT INTO students"
	    + " (Name, Grade, Age, Gender, Address, Telephone) " + "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_STUDENT_BY_ID = "SELECT Name, Grade, Age, Gender, Address, Telephone from students WHERE ID = ?";

    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM students";

    private static final String DELETE_STUDENT = "DELETE from students WHERE id = ?";

    private static final String UPDATE_STUDENT = "UPDATE students SET Name = ?, Grade = ?, Age = ?, Gender = ?, Address = ?, Telephone = ? WHERE ID = ?)";

    public StudentDAO() {
    }

//
    protected Connection getConnection() {
	Connection connection = null;

	try {
	    Class.forName(jdbcDriver);
	    connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	} catch (SQLException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}

	return connection;
    }

//  Insert Student
    public void insertStudent(Student student) throws SQLException {
	System.out.println(INSERT_STUDENT);
	try (Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)) {
	    preparedStatement.setString(1, student.getName());
	    preparedStatement.setInt(2, student.getGrade());
	    preparedStatement.setInt(3, student.getAge());
	    preparedStatement.setString(4, student.getGender());
	    preparedStatement.setString(5, student.getAddress());
	    preparedStatement.setString(6, student.getTelephone());
	    System.out.println(preparedStatement);
	    preparedStatement.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

//
//  Select all Students
    public List<Student> selectAllStudents() {
	List<Student> students = new ArrayList<>();

	try (Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {

	    System.out.println(preparedStatement);
	    ResultSet set = preparedStatement.executeQuery();

	    while (set.next()) {
		int id = set.getInt("id");
		String name = set.getString("name");
		int grade = set.getInt("grade");
		int age = set.getInt("age");
		String gender = set.getString("gender");
		String address = set.getString("address");
		String telephone = set.getString("telephone");
		students.add(new Student(id, name, grade, age, gender, address, telephone));
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return students;

    }

////
//  Select a Student
    public Student selectStudent(int id) {
	Student student = null;

	try (Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);) {
	    preparedStatement.setInt(1, id);
	    System.out.println(preparedStatement);

	    ResultSet set = preparedStatement.executeQuery();

	    while (set.next()) {
		String name = set.getString("name");
		int grade = set.getInt("grade");
		int age = set.getInt("age");
		String gender = set.getString("gender");
		String address = set.getString("address");
		String telephone = set.getString("telephone");
		student = new Student(name, grade, age, gender, address, telephone);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return student;
    }

//
//    Update Student
    public boolean updateStudent(Student student) throws SQLException {
	boolean isUpdated = false;

	try (Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);) {

	    System.out.println(preparedStatement);
	    preparedStatement.setString(1, student.getName());
	    preparedStatement.setInt(2, student.getGrade());
	    preparedStatement.setString(3, student.getGender());
	    preparedStatement.setInt(4, student.getAge());
	    preparedStatement.setString(5, student.getAddress());
	    preparedStatement.setString(6, student.getTelephone());
	    preparedStatement.setInt(7, student.getId());

	    isUpdated = preparedStatement.executeUpdate() > 0;
	}

	return isUpdated;
    }

//    Delete student
    public boolean deleteStudent(int id) throws SQLException {
	boolean isDeleted = false;

	try (Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);) {
	    preparedStatement.setInt(1, id);
	    isDeleted = preparedStatement.executeUpdate() > 0;
	}

	return isDeleted;
    }
}