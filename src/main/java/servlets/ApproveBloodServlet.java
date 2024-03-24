package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.ApproveBlood;
import db.DBCONNECTION;

/**
 * Servlet implementation class ApproveBloodServlet
 */
public class ApproveBloodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveBloodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con;
		
		String blood_type =request.getParameter("blood_type");
		int requested_amount =Integer.parseInt(request.getParameter("requested_amount"));

		
//		HttpSession session = request.getSession();
//	    String bltypeString = (String) session.getAttribute("blood_type");
		try {
			
			con = DBCONNECTION.initializeDatabase();
			
			
			String query ="SELECT Bl_type, count(*) as count FROM Blood_Stock WHERE Stock = 'available' && Bl_type = ? && Status = 'Approved' group by Bl_type";
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, blood_type);
			
			
			ResultSet rs = stmt.executeQuery();
			
			List<ApproveBlood> approvebl = new ArrayList<ApproveBlood>();
			
//			
			
			while(rs.next()) {
				ApproveBlood approveblood = new ApproveBlood();
				approveblood.setValues(rs.getString("Bl_type"),rs.getInt("count"), requested_amount);
				approvebl.add(approveblood);
			}
   
			
			
			con.close();
			request.setAttribute("approvebl", approvebl);
			RequestDispatcher rd = request.getRequestDispatcher("ApproveBlood.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
