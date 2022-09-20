package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExamDAO {

    private static ExamDAO instance;

    private String jdbcURL = "jdbc:mysql://localhost:3306/student_registration_system?useSSL=false";
    private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_EXAM = "INSERT INTO exam " + " id, term, grade, subjectName "
	    + "VALUES(?, ?, ?, ?)";

    private ExamDAO() {

    }

    public static ExamDAO getInstance() {
	if (instance == null) {
	    instance = new ExamDAO();
	}

	return instance;
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

}
