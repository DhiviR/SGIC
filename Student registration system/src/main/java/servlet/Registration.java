package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String grade = request.getParameter("grade");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		String telephone = request.getParameter("telephone");
		
		Connection connection = null;
		RequestDispatcher dispatcher;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_registration_system", "root", "root");
			
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `student_registration_system`.`students` "
					+ "(`Name`, `Grade`, `Sex`, `Age`, `Address`, `Telephone`) "
					+ "VALUES (?, ?, ?, ?, ?, ?)");
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, grade);
			preparedStatement.setString(3, sex);
			preparedStatement.setInt(4, age);
			preparedStatement.setString(5, address);
			preparedStatement.setString(6, telephone);
			
			int rowCount = preparedStatement.executeUpdate();
			dispatcher = request.getRequestDispatcher("index.jsp");
			if (rowCount > 0) {
				request.setAttribute("Status", "Success");
			} else {
				request.setAttribute("Status", "Failed");
			}
			
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
