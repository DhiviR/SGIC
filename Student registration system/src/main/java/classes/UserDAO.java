package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String DELETE_USER = "DELETE from students WHERE id = ?";

    private static final String INSERT_USERS = "INSERT INTO studetns"
	    + " (`Name`, `Grade`, `Sex`, `Age`, `Address`, `Telephone`) " + "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_ALL_USERS = "SELECT * FROM students";
    private static final String SELECT_USER_BY_ID = "SELECT Name, Grade, Sex, Age, Address, Telephone from students WHERE ID = ?";

    private static final String UPDATE_USER = "UPDATE students SET Name = ?, Grade = ?, Sex = ?, Age = ?, Address = ?, Telephone = ? WHERE ID = ?)";

    private String jdbcDriver = "com.mysql.jdbc.Driver";
    private String jdbcPassword = "root";
    private String jdbcURL = "jdbc:mysql://localhost:3306/Student_registration_system?userSSL=false";

    private String jdbcUsername = "root";

    public UserDAO() {
    }

    public boolean deleteUser(int id) {
	boolean isDeleted = false;

	try (Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);) {
	    preparedStatement.setInt(7, id);
	    isDeleted = preparedStatement.executeUpdate() > 0;

	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return isDeleted;
    }

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

//    Insert user
    public void insertUser(User user) {
	try (Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS)) {
	    preparedStatement.setString(1, user.getName());
	    preparedStatement.setInt(2, user.getGrade());
	    preparedStatement.setString(3, user.getSex());
	    preparedStatement.setInt(4, user.getAge());
	    preparedStatement.setString(5, user.getAddress());
	    preparedStatement.setString(6, user.getTelephone());

	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

//    Select all users
    public List<User> selectAllUsers() {
	List<User> users = new ArrayList<>();

	try (Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
	    ResultSet set = preparedStatement.executeQuery();

	    while (set.next()) {
		String name = set.getString(1);
		int grade = set.getInt(2);
		String sex = set.getString(3);
		int age = set.getInt(4);
		String address = set.getString(5);
		String telephone = set.getString(6);
		int id = set.getInt(7);
		users.add(new User(address, grade, age, id, name, sex, telephone));
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return users;
    }

//    Select a user
    public User selectUser(int id) {
	User user = null;

	try (Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
	    preparedStatement.setInt(1, id);
	    System.out.println(preparedStatement);

	    ResultSet set = preparedStatement.executeQuery();

	    while (set.next()) {
		String name = set.getString(1);
		int grade = set.getInt(2);
		String sex = set.getString(3);
		int age = set.getInt(4);
		String address = set.getString(5);
		String telephone = set.getString(6);
		int id1 = set.getInt(7);
		user = new User(address, grade, age, id1, name, sex, telephone);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return user;
    }

    // Update user
    public boolean updateUser(User user) {
	boolean isUpdated = false;

	try (Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);) {
	    preparedStatement.setString(1, user.getName());
	    preparedStatement.setInt(2, user.getGrade());
	    preparedStatement.setString(3, user.getSex());
	    preparedStatement.setInt(4, user.getAge());
	    preparedStatement.setString(5, user.getAddress());
	    preparedStatement.setString(6, user.getTelephone());

	    isUpdated = preparedStatement.executeUpdate() > 0;
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return isUpdated;
    }
}
