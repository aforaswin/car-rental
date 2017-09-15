package com.wipro.logic;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCarServlet
 */
@WebServlet("/delete")
public class DeleteCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CarDAO carDAO;
	
	public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        carDAO = new CarDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }   
    public DeleteCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regNo = request.getParameter("id");
		Car car = new Car(regNo);
        try {
			carDAO.deleteCar(car);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
        response.sendRedirect("http://http://localhost:8080/CarRental/list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
