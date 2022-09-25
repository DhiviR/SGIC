package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.MarksDAO;

/**
 * Servlet implementation class UpdateMarks
 */
@WebServlet("/update-marks")
public class UpdateMarks extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private MarksDAO marksDAO = MarksDAO.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMarks() {
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
	int marks = Integer.parseInt(request.getParameter("marks"));
	String marks_id = request.getParameter("marksId");

	marksDAO.updateMarks(marks_id, marks);

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
