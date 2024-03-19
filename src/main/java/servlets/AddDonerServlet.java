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
import java.sql.ResultSet;





import db.DBCONNECTION;
import thirdparty.*;

/**
 * Servlet implementation class AddDonerServlet
 */
@MultipartConfig
@WebServlet("/AddDonerServlet")
public class AddDonerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    Connection con;
	    
	    try {
			con = DBCONNECTION.initializeDatabase();
							
			String dateString = request.getParameter("DOB");
			String weightString = request.getParameter("weight");	
			Part filePart = request.getPart("pht");
			String imagePath = request.getServletContext().getRealPath("/images/Users") + File.separator;
	        String pathString = imagePath + request.getParameter("NIC") + ".jpg";
			
	        
	        
			
			int weight = Integer.parseInt(weightString);
			
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
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Add_Donor.jsp");
				requestDispatcher.include(request, response);
			}
			
			else {
				
				PreparedStatement statement1 = con.prepareStatement("insert into Person (NIC,Fname,Lname,email,password,DOB,type,gender) values (?,?,?,?,?,?,?,?)");
				
				statement1.setString(1, request.getParameter("NIC"));
				statement1.setString(2, request.getParameter("Fname"));
				statement1.setString(3, request.getParameter("Lname"));
				statement1.setString(4, request.getParameter("email"));
				statement1.setString(5, "otp");
				statement1.setDate(6, sqlDate);
				statement1.setString(7, "donor");
				statement1.setString(8, request.getParameter("gender"));
				
				System.out.println(request.getParameter("NIC"));
				
				statement1.executeUpdate();
				statement1.close();
				
				PreparedStatement statement2 = con.prepareStatement("insert into Person_P_A (NIC,type,value) values (?,?,?)");
				statement2.setString(1, request.getParameter("NIC"));
				statement2.setString(2, "phn");
				statement2.setString(3, request.getParameter("Mobilephn"));
				
				statement2.executeUpdate();
				statement2.close();
				
				PreparedStatement statement3 = con.prepareStatement("insert into Person_P_A (NIC,type,value) values (?,?,?)");
				statement3.setString(1, request.getParameter("NIC"));
				statement3.setString(2, "address");
				statement3.setString(3, request.getParameter("address"));
				
				statement3.executeUpdate();
				statement3.close();
				
				PreparedStatement statement4 = con.prepareStatement("insert into Donor (NIC,Blood_Type,weight) values (?,?,?)");
				statement4.setString(1, request.getParameter("NIC"));
				statement4.setString(2, request.getParameter("bloodType"));
				statement4.setInt(3, weight);
				
				statement4.executeUpdate();
				statement4.close();
				
				
				if (filePart != null) {
		        	InputStream fileContent = filePart.getInputStream();
		        	try (OutputStream outputStream = new FileOutputStream(pathString)) {
						int read = 0;
						final byte[] bytes = new byte[1024];
						while ((read = fileContent.read(bytes)) != -1) {
						    outputStream.write(bytes, 0, read);
						}
					}
		        	
		        	PreparedStatement stmtimage = con.prepareStatement("Update Person SET phtpath = ? where NIC = ?");
		        	stmtimage.setString(1, pathString);
		        	stmtimage.setString(2, request.getParameter("NIC"));
		        	stmtimage.executeUpdate();
		        	stmtimage.close();		        	
		        }
				
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Add_Donor_City.jsp");
				requestDispatcher.include(request, response);
			}
		
			HttpSession session = request.getSession();
		    session.setAttribute("nic", request.getParameter("NIC") );
			con.close();
			
	    } catch (ClassNotFoundException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
