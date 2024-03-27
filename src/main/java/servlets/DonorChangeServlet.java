package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



import java.io.IOException;

import java.io.PrintWriter;

import classes.Userdetails;







/**
 * Servlet implementation class AddDonerServlet
 */
@MultipartConfig
@WebServlet("/DonorChangeServlet")
public class DonorChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    
			 HttpSession session = request.getSession();
			
			 String nicString = request.getParameter("NIC");
			 Userdetails.setType("admin");
			 session.setAttribute("NICnum", nicString);
			 session.setAttribute("type", "admin");
			 
			 response.sendRedirect("UserprofileServlet");
			
	    
	}

}

