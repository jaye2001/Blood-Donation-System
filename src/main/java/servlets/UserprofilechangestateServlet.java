package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

/**
 * Servlet implementation class UserprofilechangestateServlet
 */
@WebServlet("/UserprofilechangestateServle")
public class UserprofilechangestateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		String nicString = request.getParameter("nic");
		HttpSession session = request.getSession();
	    
		session.setAttribute("nic", nicString);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Userchangestate.jsp");
		requestDispatcher.include(request, response);
	    
	}


	
}
