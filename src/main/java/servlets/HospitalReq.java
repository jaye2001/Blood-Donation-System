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
@WebServlet("/HospitalReq")

public class HospitalReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalReq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String hospital_ID = request.getParameter("hospitalID");
		String blood_type = request.getParameter("bloodType");
		String blood_points = request.getParameter("bloodpoints");
		

		RequestDispatcher dispatcher = null;
		Connection con;
		
		try {
			
			
			
			con = DBCONNECTION.initializeDatabase();
			PreparedStatement pst = con.prepareStatement("insert into Hospital_req(hospital_id, blood_type, liters) values(?,?,?)");
			pst.setString(1, hospital_ID);
			pst.setString(2, blood_type);
			pst.setString(3, blood_points);
			
			
			
			
			
			int rowCount = pst.executeUpdate();
			
			dispatcher = request.getRequestDispatcher("/HospitalReq.jsp");
			
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


