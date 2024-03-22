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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;






import db.DBCONNECTION;


/**
 * Servlet implementation class AddDonerServlet
 */
@MultipartConfig
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    Connection con;
	    HttpSession session = request.getSession();
	    
	    try {
			con = DBCONNECTION.initializeDatabase();
							
			String dateString = request.getParameter("dob");	
			
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			LocalDate yearuser = sqlDate.toLocalDate();
			
			LocalDate date2 = LocalDate.now();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
			String yearString = formatter.format(date2);
			String yearuserString = formatter.format(yearuser);
			
			int year = Integer.parseInt(yearString);
			int yearuserint = Integer.parseInt(yearuserString);
			
			if (year - yearuserint < 18) {
				response.sendRedirect("UserprofileServlet");
			}
			
			else {
				
				PreparedStatement statement1 = con.prepareStatement("UPDATE Person SET NIC = ?,Fname = ?,Lname = ?,email = ?,DOB = ?,address = ? where NIC = ?");
				
				statement1.setString(1, request.getParameter("nic"));
				statement1.setString(2, request.getParameter("Fname"));
				statement1.setString(3, request.getParameter("Lname"));
				statement1.setString(4, request.getParameter("email"));
				statement1.setDate(5, sqlDate);
				statement1.setString(6, request.getParameter("address"));
				statement1.setString(7, (String) session.getAttribute("nic"));
				
				System.out.println(request.getParameter("NIC"));
				
				statement1.executeUpdate();
				statement1.close();
				
//				PreparedStatement statement2 = con.prepareStatement("insert into Person_P_A (NIC,type,value) values (?,?,?)");
//				statement2.setString(1, request.getParameter("NIC"));
//				statement2.setString(2, "phn");
//				statement2.setString(3, request.getParameter("Mobilephn"));
//				
//				statement2.executeUpdate();
//				statement2.close();
//				
//				PreparedStatement statement3 = con.prepareStatement("insert into Person_P_A (NIC,type,value) values (?,?,?)");
//				statement3.setString(1, request.getParameter("NIC"));
//				statement3.setString(2, "address");
//				
//				
//				statement3.executeUpdate();
//				statement3.close();
				
				
				
				
				response.sendRedirect("UserprofileServlet");
			}
		
			
		    
			con.close();
			
	    } catch (ClassNotFoundException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}