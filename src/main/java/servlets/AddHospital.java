package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.http.Part;

import db.DBCONNECTION;

/**
 * Servlet implementation class campServlet
 */
@WebServlet("/AddHospital")

public class AddHospital extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHospital() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		

		
		
		
		
		
		RequestDispatcher dispatcher = null;
		Connection con;
		
		try {
			
			
			
			con = DBCONNECTION.initializeDatabase();
			PreparedStatement pst = con.prepareStatement("insert into Hospital(Name, Location, email, password) values(?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2, location);
			pst.setString(3, email);
			pst.setString(4, password);
			
			
			
			
			int rowCount = pst.executeUpdate();
			
			dispatcher = request.getRequestDispatcher("/HospitalRegister.jsp");
			
			if (rowCount > 0) {
				request.setAttribute("status", "success");
				
			}else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);
			
			
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		

		
	}

}


