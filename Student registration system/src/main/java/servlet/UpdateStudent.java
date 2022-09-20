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
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/update-student")
public class UpdateStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StudentDAO studentDAO = StudentDAO.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
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
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	int grade = Integer.parseInt(request.getParameter("grade"));
	String gender = request.getParameter("gender");
	int age = Integer.parseInt(request.getParameter("age"));
	String address = request.getParameter("address");
	String telephone = request.getParameter("telephone");

//		System.out.println(id + " " + name + " " + grade + " " + gender + " " + age + " " + address + " " + telephone);

	Student student = new Student(id, name, grade, age, gender, address, telephone);

	try {
	    studentDAO.updateStudent(student);
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
