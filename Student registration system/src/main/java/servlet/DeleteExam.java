package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.ExamDAO;

/**
 * Servlet implementation class DeleteExam
 */
@WebServlet("/delete-exam")
public class DeleteExam extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ExamDAO examDAO = ExamDAO.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteExam() {
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
	int examId = Integer.parseInt(request.getParameter("id"));

	examDAO.deleteExam(examId);

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