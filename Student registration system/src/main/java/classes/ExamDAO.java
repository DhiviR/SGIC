package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExamDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/student_registration_system?useSSL=false";
    private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_EXAM = "INSERT INTO exam " + " id, term, grade, subjectName "
	    + "VALUES(?, ?, ?, ?)";

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
