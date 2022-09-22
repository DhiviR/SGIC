package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection databaseConnection;

    private DatabaseConnection() {

    }

    public static DatabaseConnection getDatabaseConnection() {
	if (databaseConnection == null) {
	    databaseConnection = new DatabaseConnection();
	}

	return databaseConnection;
    }

    private String jdbcURL = "jdbc:mysql://localhost:3306/student_registration_system?useSSL=false";
    private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    public Connection getConnection() {
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
