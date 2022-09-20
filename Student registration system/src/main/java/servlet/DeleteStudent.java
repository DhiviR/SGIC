package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.StudentDAO;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/delete-student")
public class DeleteStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StudentDAO studentDAO = StudentDAO.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
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
	try {
	    studentDAO.deleteStudent(id);
	} catch (Exception e) {
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
