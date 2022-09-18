package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.ExamDAO;

/**
 * Servlet implementation class ExamServlet
 */
@WebServlet("/exams")
public class ExamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ExamDAO examDAO;

    @Override
    public void init() {
	examDAO = new ExamDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String action = request.getServletPath();

	try {
	    switch (action) {

//    	    case "/insert":
//    		insert(request, response);
//		break;

	    default:
		listExam(request, response);
		break;
	    }
	} catch (SQLException ex) {
	    ex.printStackTrace();
	}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	doGet(request, response);
    }

//  Home page list exams
    private void listExam(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException, ServletException {
//	List<Exam> listStudent = examDAO.selectAllExams();
//	request.setAttribute("listExam", listExam);
	RequestDispatcher dispatcher = request.getRequestDispatcher("exam-home.jsp");
	dispatcher.forward(request, response);
    }
}
