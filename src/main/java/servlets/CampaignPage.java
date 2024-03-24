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

import classes.CampaignHis;
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
			
			String query ="select Campaign_ID, Campain_name, Location, Date, STime, Image, Description from Campaign_Details where Date > curdate()";

			ResultSet rs = stmt.executeQuery(query);
			
			List<Campaign> campaigns = new ArrayList<Campaign>();
			
			while(rs.next()) {
				Campaign campaign = new Campaign();
				campaign.Set_Values(rs.getInt("Campaign_ID"),rs.getString("Campain_name"),rs.getString("Date"),rs.getString("STime"),rs.getString("Location"),rs.getString("Image"),rs.getString("Description"));
				campaigns.add(campaign);
			}
			
			String query1 ="select Campain_name, Description, Image from Campaign_Details where Date < curdate()";
			ResultSet rs1 = stmt.executeQuery(query1);
			List<CampaignHis> campaignhis = new ArrayList<CampaignHis>();
			
			while(rs1.next()) {
				CampaignHis campaignh = new CampaignHis();
				campaignh.Set_Values(rs1.getString("Campain_name"), rs1.getString("Description"), rs1.getString("Image"));
				campaignhis.add(campaignh);
				
			}

			
			con.close();
			request.setAttribute("campaigns", campaigns);
			request.setAttribute("campaignhis", campaignhis);
			RequestDispatcher rd = request.getRequestDispatcher("Campaign.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

