package com.wipro.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.connection.CarDAO;
import com.wipro.model.Car;



/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarDAO carDAO;
	
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
       
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        
        carDAO = new CarDAO(jdbcURL, jdbcUsername, jdbcPassword);
        
 
    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession s=request.getSession();
	        String n=(String)s.getAttribute("name");
	        if(n!=null &&n.equals("user"))
	        {
	        	List<Car> listCar;
				try {
					listCar = carDAO.listAllCars();
				} catch (SQLException e) {
					throw new ServletException(e);
				}
	            request.setAttribute("listCar", listCar);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
	            dispatcher.forward(request, response);
	        }
	        else
	        {
	        	RequestDispatcher r=request.getRequestDispatcher("userLogin.jsp");
	        	r.forward(request, response);
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
