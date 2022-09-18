package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Student;
import classes.StudentDAO;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StudentDAO studentDAO;

    @Override
    public void init() {
	studentDAO = new StudentDAO();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String action = request.getServletPath();

	try {
	    switch (action) {

	    case "/register":
		register(request, response);
		break;

	    case "/insert":
		insert(request, response);
		break;

	    case "/edit":
		showEditForm(request, response);
		break;

	    case "/delete":
		deleteStudent(request, response);
		break;

	    case "/update":
		updateStudent(request, response);
		break;

	    default:
		listStudent(request, response);
		break;
	    }
	} catch (SQLException ex) {
	    ex.printStackTrace();
	}

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	doGet(request, response);
    }

//    Home page list students
    private void listStudent(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException, ServletException {
	List<Student> listStudent = studentDAO.selectAllStudents();
	request.setAttribute("listStudent", listStudent);
	RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
	dispatcher.forward(request, response);
    }

//    Redirect to new registration form
    private void register(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	RequestDispatcher dispatcher = request.getRequestDispatcher("new-form.jsp");
	dispatcher.forward(request, response);
    }

//    Insert user
    private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
	String name = request.getParameter("name");
	int grade = Integer.parseInt(request.getParameter("grade"));
	int age = Integer.parseInt(request.getParameter("age"));
	String gender = request.getParameter("gender");
	String address = request.getParameter("address");
	String telephone = request.getParameter("telephone");

	Student student = new Student(name, grade, age, gender, address, telephone);
	studentDAO.insertStudent(student);

	response.sendRedirect("listStudent");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException, ServletException {
	int id = Integer.parseInt(request.getParameter("id"));

	Student existingStudent = studentDAO.selectStudent(id);
	RequestDispatcher dispatcher = request.getRequestDispatcher("new-form.jsp");
	request.setAttribute("student", existingStudent);
	dispatcher.forward(request, response);

    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, SQLException {
	int id = Integer.parseInt(request.getParameter("id"));
	try {
	    studentDAO.deleteStudent(id);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	response.sendRedirect("listStudent");
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	int grade = Integer.parseInt(request.getParameter("grade"));
	String gender = request.getParameter("gender");
	int age = Integer.parseInt(request.getParameter("age"));
	String address = request.getParameter("address");
	String telephone = request.getParameter("telephone");

//	System.out.println(id + " " + name + " " + grade + " " + gender + " " + age + " " + address + " " + telephone);

	Student student = new Student(id, name, grade, age, gender, address, telephone);

	studentDAO.updateStudent(student);
	response.sendRedirect("listStudent");
    }

}
