package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBCONNECTION;

/**
 * Servlet implementation class CampaignPage
 */
@WebServlet("/CampaignPage")
public class CampaignPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CampaignPage() {
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
			Statement stmt = con.createStatement();
			
			String query ="select Campaign_ID as id, Campain_name as name, Location, Date, STime, Image, Description from Campaign_Details";

			ResultSet rs = stmt.executeQuery(query);
			
			List<Campaign> campaigns = new ArrayList<Campaign>();
			
			while(rs.next()) {
				Campaign campaign = new Campaign();
				campaign.Set_Values(rs.getInt("id"),rs.getString("name"),rs.getString("Date"),rs.getString("STime"),rs.getString("Location"),rs.getString("Image"),rs.getString("Description"));
				campaigns.add(campaign);
			}
			con.close();
			request.setAttribute("campaigns", campaigns);
			RequestDispatcher rd = request.getRequestDispatcher("Campaign.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

