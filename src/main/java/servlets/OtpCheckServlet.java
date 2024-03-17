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
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.print.attribute.standard.OrientationRequested;

import java.sql.ResultSet;



import db.DBCONNECTION;
import thirdparty.*;

/**
 * Servlet implementation class OtpCheckServlet
 */
@WebServlet("/OtpCheckServlet")
public class OtpCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    
	    // get session attributes from login servlet
	    HttpSession session = request.getSession();
	    String emailString = (String) session.getAttribute("email");
	    int otp = (int) session.getAttribute("pin");
	    
	    // get parameters from otp.jsp
	    int userpin = Integer.parseInt(request.getParameter("OTP"));
	    
	    if (userpin == otp) {
			
	    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home.jsp");
	    	requestDispatcher.forward(request, response);
	    	
		}
	    
	    else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/otpenter.jsp");
			requestDispatcher.forward(request, response);
			}
		
	    
		
	}

}
