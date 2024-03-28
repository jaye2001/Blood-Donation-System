package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBCONNECTION;

/**
 * Servlet implementation class DonorEligibilityServlet
 */
public class DonorEligibilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorEligibilityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String donor_NIC = request.getParameter("NIC");
		String donor_name = "";
		String donor_email = "";
		
		 Connection con;
	       
	        try {
	        	
	        	
	        	con = DBCONNECTION.initializeDatabase();
	        	
	            PreparedStatement pstmt = null;
	            ResultSet rs;
	        	
	            String sql = "SELECT * FROM Person WHERE NIC = ?";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, donor_NIC);
	            rs = pstmt.executeQuery();
//	            System.out.println(rs.getString(0));
//	            donor_name = rs.getString("Fname") + " " + rs.getString("Lname");
//	            donor_email = rs.getString("email");
//	            while(rs.next()) {
//	            }
	            if (rs.next()) {
	                System.out.println(rs.getString("NIC")); // It's better to use column names
	                donor_name = rs.getString("Fname") + " " + rs.getString("Lname");
	                donor_email = rs.getString("email");
	                
	                // Set attributes for use in the JSP
	                request.setAttribute("donor_NIC", donor_NIC);
	                request.setAttribute("donor_name", donor_name);
	                request.setAttribute("donor_email", donor_email);
	                request.getRequestDispatcher("/Eligibility_Donor.jsp").forward(request, response);
	            } else {
	            	throw new SQLException();
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace(); 
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error in retrieving person details: A donor with the provided NIC does not exist.");
	        } 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
