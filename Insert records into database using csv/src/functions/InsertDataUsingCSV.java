package functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataUsingCSV {
    DatabaseConnection dbConnection = DatabaseConnection.getDatabaseConnection();

    private String INSERT_DATA = "INSERT INTO users(username, first_name, last_name, NIC_no, address) VALUES(?, ?, ?, ?, ?)";

    public void insertData(File file) throws FileNotFoundException {
	int batchSize = 20;

	Connection connection = dbConnection.getConnection();
	try {
	    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DATA);

	    BufferedReader reader = new BufferedReader(new FileReader(file));

	    String lineText;
	    while ((lineText = reader.readLine()) != null) {
		String[] data = lineText.split(",");

		String username = data[0];
		String firstName = data[1];
		String lastName = data[2];
		String nicNo = data[3];
		String address = data[4];

		preparedStatement.setString(1, username);
		preparedStatement.setString(2, firstName);
		preparedStatement.setString(3, lastName);
		preparedStatement.setString(4, nicNo);
		preparedStatement.setString(5, address);
		System.out.println(preparedStatement);
		preparedStatement.executeUpdate();

	    }
	    reader.close();
	    connection.close();

	} catch (SQLException | IOException e) {
	    e.printStackTrace();
	}

    }
}
