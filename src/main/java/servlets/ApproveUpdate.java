package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.ApproveBlood;
import db.DBCONNECTION;

/**
 * Servlet implementation class ApproveUpdate
 */
public class ApproveUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con;
		
		String blood_type =request.getParameter("blood_type");
		int requested_amount =Integer.parseInt(request.getParameter("requested_amount"));
		
		try {
			
			con = DBCONNECTION.initializeDatabase();
			
			
			

	        String query1 = "UPDATE Blood_Stock SET Stock = 'Donated' WHERE Stock = 'available' && Bl_type = ? && Status ='Approved' LIMIT ?";
	        PreparedStatement stmt1 = con.prepareStatement(query1);
	        stmt1.setString(1, blood_type);
	        stmt1.setInt(2, requested_amount);
	        
	        int rowsAffected = stmt1.executeUpdate();
			
			
			con.close();
			
			System.out.println("error");
			
			RequestDispatcher rd = request.getRequestDispatcher("ApproveBlood.jsp");
			rd.include(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
