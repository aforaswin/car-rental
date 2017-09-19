package com.wipro.logic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/user")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
	   	 
        if(s.isNew())
        {
        	System.out.println("New login as user");
        	response.sendRedirect("userLogin.jsp");
            return;
        }
        else 
        {
        	
				String n=(String)s.getAttribute("name");
				if(n.equals("Aswin"))
				{
					s.invalidate();
					s = request.getSession();
					System.out.println("New login as user");
					response.sendRedirect("userLogin.jsp");
				    return;
				}
			
        }
        
        System.out.println("same session");
        response.sendRedirect("http://localhost:8080/CarRental/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
