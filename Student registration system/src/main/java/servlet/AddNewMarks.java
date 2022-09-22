package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Exam;
import classes.ExamDAO;
import classes.Student;
import classes.StudentDAO;

/**
 * Servlet implementation class AddNewMarks
 */
@WebServlet("/add-new-marks")
public class AddNewMarks extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ExamDAO examDAO = ExamDAO.getInstance();
    private StudentDAO studentDAO = StudentDAO.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewMarks() {
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
	List<Exam> listExam = examDAO.selectAllExams();
	List<Student> listStudent = studentDAO.selectAllStudents();
	request.setAttribute("listStudent", listStudent);
	request.setAttribute("listExam", listExam);
	RequestDispatcher dispatcher = request.getRequestDispatcher("add-new-marks.jsp");
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
