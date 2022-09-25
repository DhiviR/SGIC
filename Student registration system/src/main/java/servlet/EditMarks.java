package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.ExamDAO;
import classes.Marks;
import classes.MarksDAO;
import classes.StudentDAO;

/**
 * Servlet implementation class EditMarks
 */
@WebServlet("/edit-marks")
public class EditMarks extends HttpServlet {
    private static final long serialVersionUID = 1L;

    MarksDAO marksDAO = MarksDAO.getInstance();
    ExamDAO examDAO = ExamDAO.getInstance();
    StudentDAO studentDAO = StudentDAO.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMarks() {
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
	String marksId = request.getParameter("id");

	Marks existingMarks = marksDAO.selectMarks(marksId);
	RequestDispatcher dispatcher = request.getRequestDispatcher("add-new-marks.jsp");
	request.setAttribute("marks", existingMarks);
	dispatcher.forward(request, response);
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
