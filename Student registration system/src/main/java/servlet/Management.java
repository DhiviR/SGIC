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

import classes.User;
import classes.UserDAO;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/")
public class Management extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String action = request.getServletPath();

	switch (action) {
	case "/register":
	    register(request, response);
	    break;

	case "/insert":
	    insert(request, response);
	    break;

	case "/edit":
	    try {
		showEditForm(request, response);
	    } catch (SQLException e1) {
		e1.printStackTrace();
	    }
	    break;

	case "/delete":
	    deleteUser(request, response);
	    break;

	case "/update":
	    try {
		updateUser(request, response);
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	    break;

	default:
	    try {
		listUser(request, response);
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	    break;
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

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name = request.getParameter("name");
	int grade = Integer.parseInt(request.getParameter("grade"));
	String sex = request.getParameter("sex");
	int age = Integer.parseInt(request.getParameter("age"));
	String address = request.getParameter("address");
	String telephone = request.getParameter("telephone");

	User user = new User(address, grade, age, name, sex, telephone);
	userDAO.insertUser(user);

	response.sendRedirect("list");
    }

    private void register(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
	dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	try {
	    userDAO.deleteUser(id);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	response.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException, ServletException {
	int id = Integer.parseInt(request.getParameter("id"));

	User existingUser = userDAO.selectUser(id);
	RequestDispatcher dispatcher = request.getRequestDispatcher("registraion.jsp");
	request.setAttribute("user", existingUser);
	dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	int grade = Integer.parseInt(request.getParameter("grade"));
	String sex = request.getParameter("sex");
	int age = Integer.parseInt(request.getParameter("age"));
	String address = request.getParameter("address");
	String telephone = request.getParameter("telephone");

	User user = new User(address, grade, age, id, name, sex, telephone);

	userDAO.updateUser(user);
	response.sendRedirect("list");
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException, ServletException {
	List<User> listUser = userDAO.selectAllUsers();
	request.setAttribute("listUser", listUser);
	RequestDispatcher dispatcher = request.getRequestDispatcher("userList.jsp");
	dispatcher.forward(request, response);
    }

}
