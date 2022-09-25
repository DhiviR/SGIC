package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDAO {

    private static ExamDAO instance;

    DatabaseConnection databaseConnection = DatabaseConnection.getDatabaseConnection();

    private static final String INSERT_EXAM = "INSERT INTO exams" + " (exam_id, term, grade, subject) "
	    + "VALUES (?, ?, ?, ?)";

    private static final String SELECT_ALL_EXAMS = "SELECT * FROM exams";

    private static final String SELECT_EXAM_BY_ID = "SELECT exam_id, term, grade, subject FROM exams WHERE exam_id = ?";

    private static final String UPDATE_EXAM = "UPDATE exams SET term = ?, grade = ?, subject = ? WHERE exam_id = ?";

    private static final String DELETE_EXAM = "DELETE FROM exams WHERE exam_id = ?";

    private ExamDAO() {

    }

    public static ExamDAO getInstance() {
	if (instance == null) {
	    instance = new ExamDAO();
	}

	return instance;
    }

    public List<Exam> selectAllExams() {
	List<Exam> examList = new ArrayList<>();

	try (Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EXAMS);) {

	    System.out.println(preparedStatement);
	    ResultSet set = preparedStatement.executeQuery();

	    while (set.next()) {
		String examId = set.getString("exam_id");
		int term = set.getInt("term");
		int grade = set.getInt("grade");
		String subject = set.getString("subject");

		examList.add(new Exam(examId, term, grade, subject));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return examList;
    }

    public void insertExam(Exam exam) {
	try (Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EXAM);) {
	    preparedStatement.setString(1, exam.getExamId());
	    preparedStatement.setInt(2, exam.getTerm());
	    preparedStatement.setInt(3, exam.getGrade());
	    preparedStatement.setString(4, exam.getSubject());
	    System.out.println(preparedStatement);
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public Exam selectExam(String examId) {
	Exam exam = null;
	try (Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EXAM_BY_ID);) {
	    preparedStatement.setString(1, examId);
	    System.out.println(preparedStatement);

	    ResultSet set = preparedStatement.executeQuery();
	    while (set.next()) {
		int term = set.getInt("term");
		int grade = set.getInt("grade");
		String subject = set.getString("subject");

		exam = new Exam(examId, term, grade, subject);

		System.out.println(term + " " + grade + " " + subject);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return exam;
    }

    public boolean updateExam(Exam exam) throws SQLException {
	boolean isUpdated = false;

	try (Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EXAM);) {
	    preparedStatement.setInt(1, exam.getTerm());
	    preparedStatement.setInt(2, exam.getGrade());
	    preparedStatement.setString(3, exam.getSubject());
	    preparedStatement.setString(4, exam.getExamId());
	    System.out.println(preparedStatement);
	    isUpdated = preparedStatement.executeUpdate() > 0;
	}

	return isUpdated;
    }

    public void deleteExam(String examId) {
	try (Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EXAM)) {
	    preparedStatement.setString(1, examId);
	    System.out.println(preparedStatement);
	    preparedStatement.executeUpdate();
	} catch (SQLException e) {

	    e.printStackTrace();
	}
    }
}
