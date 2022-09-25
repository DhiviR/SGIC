package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Exam;
import classes.ExamDAO;

/**
 * Servlet implementation class UpdateExam
 */
@WebServlet("/update-exam")
public class UpdateExam extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ExamDAO examDAO = ExamDAO.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExam() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	String examId = request.getParameter("examId");
	int term = Integer.parseInt(request.getParameter("term"));
	int grade = Integer.parseInt(request.getParameter("grade"));
	String subject = request.getParameter("subject");

	Exam exam = new Exam(examId, term, grade, subject);

	try {
	    examDAO.updateExam(exam);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	response.sendRedirect("exams");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
