package com.wipro.logic;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCarServlet
 */
@WebServlet("/update")
public class UpdateCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CarDAO carDAO;
	
	public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        carDAO = new CarDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }   
	
    public UpdateCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regNo = request.getParameter("reg_no");
        String companyName = request.getParameter("company_name");
        String carName = request.getParameter("car_name");
        String type = request.getParameter("type");
        int noOfSeats = Integer.parseInt(request.getParameter("no_of_seats"));
        double rent = Double.parseDouble(request.getParameter("rent"));
        Car car=new Car(companyName,carName,type, regNo, rent, noOfSeats);
        try {
			carDAO.updateCar(car);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
        response.sendRedirect("http://localhost:8080/CarRental/list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
