package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Exam;
import classes.ExamDAO;

/**
 * Servlet implementation class InsertExam
 */
@WebServlet("/insert-exam")
public class InsertExam extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ExamDAO examDAO = ExamDAO.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertExam() {
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

	int term = Integer.parseInt(request.getParameter("term"));
	int grade = Integer.parseInt(request.getParameter("grade"));
	String subject = request.getParameter("subject");
	String examId = subject.charAt(0) + Integer.toString(grade) + Integer.toString(term);

	examDAO.insertExam(new Exam(examId, term, grade, subject));

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
