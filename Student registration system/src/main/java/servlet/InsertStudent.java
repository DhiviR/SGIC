package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Student;
import classes.StudentDAO;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/insert-student")
public class InsertStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StudentDAO studentDAO = StudentDAO.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudent() {
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
	String name = request.getParameter("name");
	int grade = Integer.parseInt(request.getParameter("grade"));
	int age = Integer.parseInt(request.getParameter("age"));
	String gender = request.getParameter("gender");
	String address = request.getParameter("address");
	String telephone = request.getParameter("telephone");

	Student student = new Student(name, grade, age, gender, address, telephone);
	try {
	    studentDAO.insertStudent(student);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	response.sendRedirect("students");
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
