package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBCONNECTION;

/**
 * Servlet implementation class CustomApprove
 */
public class CustomApprove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomApprove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con;
		
		String blood_type =request.getParameter("blood_type");
		int custom =Integer.parseInt(request.getParameter("custom"));
		
		try {
			
			con = DBCONNECTION.initializeDatabase();
			
			
			

	        String query1 = "UPDATE Blood_Stock SET Stock = 'Donated' WHERE Stock = 'available' && Bl_type = ? && Status ='Approved' LIMIT ?";
	        PreparedStatement stmt1 = con.prepareStatement(query1);
	        stmt1.setString(1, blood_type);
	        stmt1.setInt(2, custom);
	        
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
