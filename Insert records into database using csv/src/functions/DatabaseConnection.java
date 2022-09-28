package functions;

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

    String jdbcURL = "jdbc:mysql://localhost:3306/db_for_insert_using_csv?useSSL=false";
    String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    String jdbcUsername = "root";
    String jdbcPassword = "root";

    public Connection getConnection() {
	Connection connection = null;

	try {
	    Class.forName(jdbcDriver);
	    connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	} catch (ClassNotFoundException e) {

	    e.printStackTrace();
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return connection;

    }
}
