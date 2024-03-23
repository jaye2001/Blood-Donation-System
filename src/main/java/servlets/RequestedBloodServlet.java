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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.RequestedBlood;

import db.DBCONNECTION;

/**
 * Servlet implementation class DonationHistory
 */
public class RequestedBloodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestedBloodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con;
		try {
			
			con = DBCONNECTION.initializeDatabase();
			
			
			String query ="SELECT Hospital_req.hospital_id, Hospital_req.blood_type, Hospital_req.liters, Hospital.Name FROM Hospital_req JOIN Hospital ON Hospital_req.hospital_id=Hospital.id";
			PreparedStatement stmt = con.prepareStatement(query);
			

			ResultSet rs = stmt.executeQuery();
			
			List<RequestedBlood> reqblood = new ArrayList<RequestedBlood>();
			
			while(rs.next()) {
				RequestedBlood rblood = new RequestedBlood();
				rblood.setValues(rs.getInt("hospital_id"),rs.getString("blood_type"),rs.getInt("liters"),rs.getString("Name"));
				reqblood.add(rblood);
			}
			con.close();
			request.setAttribute("reqblood", reqblood);
			RequestDispatcher rd = request.getRequestDispatcher("ViewBloodRequests.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
