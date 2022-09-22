package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Student;
import classes.StudentDAO;

/**
 * Servlet implementation class EditStudent
 */
@WebServlet("/edit-student")
public class EditStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StudentDAO studentDAO = StudentDAO.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudent() {
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
	int studentId = Integer.parseInt(request.getParameter("id"));

	Student existingStudent = studentDAO.selectStudent(studentId);
	RequestDispatcher dispatcher = request.getRequestDispatcher("add-new-student.jsp");
	request.setAttribute("student", existingStudent);
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
