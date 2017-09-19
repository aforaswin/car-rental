package com.wipro.logic;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.connection.UserDAO;
import com.wipro.model.User;

/**
 * Servlet implementation class InsertUserServlet
 */
@WebServlet("/insertUser")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private UserDAO userDAO;
	
	public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}
    public InsertUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String address = request.getParameter("address");
        String email = request.getParameter("email_id");
        long phoneNo = Long.parseLong(request.getParameter("phone_no"));
        String userName=request.getParameter("user_name");
        String password=request.getParameter("password");
        
        User user = new User(phoneNo,firstName,lastName,address,email,userName,password);
        
        try {
			userDAO.insertUser(user);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("userLogin.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
