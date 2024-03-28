package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.ResultSet;
import java.sql.Date;





import db.DBCONNECTION;
import thirdparty.*;
import classes.Userdetails;

/**
 * Servlet implementation class AddDonerServlet
 */
@MultipartConfig
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();

		
			
			 HttpSession session = request.getSession();
			
			 session.removeAttribute("NICnum");
		
			
			 
			
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Login.jsp");
			requestDispatcher.include(request, response);
			
			
		   
			
			
			
			
		    //session.setAttribute("nic", request.getParameter("nic") );
			
			
	
				
				
				
			
	    
	}

}
