package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Marks;
import classes.MarksDAO;

/**
 * Servlet implementation class InsertMarks
 */
@WebServlet("/insert-marks")
public class InsertMarks extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private MarksDAO marksDAO = MarksDAO.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMarks() {
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
	String marksId = request.getParameter("studentId") + "-" + request.getParameter("examId");
	int studentId = Integer.parseInt(request.getParameter("studentId"));
	String examId = request.getParameter("examId");
	int marks = Integer.parseInt(request.getParameter("marks"));

	marksDAO.insertMarks(new Marks(marksId, studentId, examId, marks));

	response.sendRedirect("marks");

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
