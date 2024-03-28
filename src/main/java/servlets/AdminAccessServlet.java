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
@WebServlet("/AdminAccessServlet")
public class AdminAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    Connection con;
		 try {
			con = DBCONNECTION.initializeDatabase();
			 HttpSession session = request.getSession();
			
			PreparedStatement st = con.prepareStatement("call select_user_email( ? );");
			st.setString(1, (String) session.getAttribute("nic"));
			ResultSet rs = st.executeQuery();
		
			Userdetails Userdetails1 = new Userdetails();
			 
			while (rs.next()) {
				
				
				Date sqlDate = rs.getDate("DOB");
		        Userdetails1.setUser(rs.getString("NIC"), rs.getString("Fname"),rs.getString("Lname"),rs.getString("email"),sqlDate ,rs.getString("gender"),rs.getString("phtpath"),rs.getString("phnNum"),rs.getString("address"),rs.getString("Blood_Type"),rs.getInt("weight"),rs.getInt("provinceid"),rs.getInt("DistricId"),rs.getInt("CityId"),rs.getString("Pname_en"),rs.getString("Dname_en"),rs.getString("Cname_en"));
				Userdetails.setType((String) session.getAttribute("type"));
				//System.out.println(rs.getInt("id")+rs.getString("name_en"));
				
			}
			request.setAttribute("Userdetails1", Userdetails1);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home.jsp");
			requestDispatcher.include(request, response);
			
			
		   
			
			st.close();
			
			
		    session.setAttribute("nic", request.getParameter("nic") );
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
				
			
	    
	}

}
