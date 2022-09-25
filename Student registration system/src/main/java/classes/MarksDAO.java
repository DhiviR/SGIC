package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarksDAO {
    private static MarksDAO instance;

    DatabaseConnection databaseConnection = DatabaseConnection.getDatabaseConnection();

    private static final String INSERT_MARKS = "INSERT INTO marks" + " (marks_id, student_id, exam_id, marks) "
	    + "VALUES (?, ?, ?, ?)";

    private static final String SELECT_ALL_MARKS = "SELECT * FROM marks";

    private static final String SELECT_MARKS_BY_ID = "SELECT marks_id, student_id, exam_id, marks FROM marks WHERE marks_id = ?";

    private static final String UPDATE_MARKS = "UPDATE marks SET marks = ? WHERE marks_id = ?";

    private static final String DELETE_MARKS = "DELETE FROM marks WHERE marks_id = ?";

    private MarksDAO() {

    }

    public static MarksDAO getInstance() {
	if (instance == null) {
	    instance = new MarksDAO();
	}

	return instance;
    }

    public List<Marks> selectAllMarks() {
	List<Marks> marksList = new ArrayList<>();

	try (Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MARKS);) {

	    System.out.println(preparedStatement);
	    ResultSet set = preparedStatement.executeQuery();

	    while (set.next()) {
		String marksId = set.getString("marks_id");
		int studentId = set.getInt("student_id");
		String examId = set.getString("exam_id");
		int marks = set.getInt("marks");

		marksList.add(new Marks(marksId, studentId, examId, marks));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return marksList;
    }

    public void insertMarks(Marks marks) {
	try (Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MARKS);) {

	    preparedStatement.setString(1, marks.getMarksId());
	    preparedStatement.setInt(2, marks.getStudentId());
	    preparedStatement.setString(3, marks.getExamId());
	    preparedStatement.setInt(4, marks.getMarks());
	    System.out.println(preparedStatement);
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public Marks selectMarks(String marksId) {
	Marks marksObj = null;
	try (Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MARKS_BY_ID);) {
	    preparedStatement.setString(1, marksId);
	    System.out.println(preparedStatement);

	    ResultSet set = preparedStatement.executeQuery();
	    while (set.next()) {

		int studentId = set.getInt("student_id");
		String examId = set.getString("exam_id");
		int marks = set.getInt("marks");

		marksObj = new Marks(marksId, studentId, examId, marks);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return marksObj;
    }

    public boolean updateMarks(String marksId, int marks) {
	boolean isUpdated = false;

	try (Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MARKS)) {
	    preparedStatement.setInt(1, marks);
	    preparedStatement.setString(2, marksId);
	    System.out.println(preparedStatement);
	    isUpdated = preparedStatement.executeUpdate() > 0;
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return isUpdated;
    }

    public void deleteMarks(String marksId) {
	try (Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MARKS)) {
	    preparedStatement.setString(1, marksId);
	    System.out.println(preparedStatement);
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

}
