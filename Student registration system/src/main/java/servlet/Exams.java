package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.ExamDAO;

/**
 * Servlet implementation class ExamServlet
 */
@WebServlet("/exams")
public class Exams extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ExamDAO examDAO = ExamDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
//	List<Exam> listExam = examDAO.selectAllExams();
//	request.setAttribute("listExam", listExam);
	RequestDispatcher dispatcher = request.getRequestDispatcher("exam-home.jsp");
	dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	doGet(request, response);
    }
}
