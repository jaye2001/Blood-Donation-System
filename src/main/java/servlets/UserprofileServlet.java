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
@WebServlet("/UserprofileServlet")
public class UserprofileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    Connection con;
		 try {
			con = DBCONNECTION.initializeDatabase();
			
			PreparedStatement st = con.prepareStatement("call select_user_email(   );");
			ResultSet rs = st.executeQuery();
			
			
			 
			while (rs.next()) {
				
				
				loader.SetList(rs.getInt("id"), rs.getString("name_en"));
				
				//System.out.println(rs.getInt("id")+rs.getString("name_en"));
				
			}
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Add_Donor_City.jsp");
			requestDispatcher.include(request, response);
			
			HttpSession session = request.getSession();
		    session.setAttribute("nic", request.getParameter("NIC") );
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
				
			
	    
	}

}
