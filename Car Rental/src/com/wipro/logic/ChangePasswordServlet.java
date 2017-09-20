package com.wipro.logic;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.connection.UserDAO;
import com.wipro.model.User;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
	
	public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		User u=(User)s.getAttribute("user");
		String p1=u.getPassword();
		String p2=request.getParameter("old_password");
		String p3=request.getParameter("password");
		
		if(p1.equals(p2)&&!(p2.equals(p3))){
			u.setPassword(p3);
			try {
				userDAO.updateUser(u,u.getPhoneNo());
			} catch (SQLException e) {
				throw new ServletException(e);
			}
			
			response.sendRedirect("http://localhost:8080/CarRental/home");
		}
		
		else{
			request.setAttribute("message", "Please ensure that the old password and new password are sane and that the old password is correct");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Change.jsp");
	        dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
