package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.exceptions.RSAException;

import db.DBCONNECTION;
import classes.*;

/**
 * Servlet implementation class AddDonerCityServlet
 */
@WebServlet("/AddCampaignCity")
public class AddCampaignCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		Connection con;
		HttpSession session = request.getSession();
	    String nameString = (String) session.getAttribute("name");
	    String dateString = (String) session.getAttribute("date");
	    
		
		try {
			con = DBCONNECTION.initializeDatabase();
			String valueString = request.getParameter("country-Province");
			//System.out.println(valueString);
			
			if("province".equals(request.getParameter("hiddenP"))) {
				PreparedStatement stmt = con.prepareStatement("UPDATE Campaign_Details SET Province = ? Where Campain_name = ? && Date = ?");
				stmt.setInt(1, Integer.parseInt(request.getParameter("country-Province")));
				stmt.setString(2, nameString);
				stmt.setString(3, dateString);
				stmt.executeUpdate();
				stmt.close();
				//System.out.println("wada");
				//Loader myobj2 = new Loader();
			  DistricLoader.setNumber(Integer.parseInt(request.getParameter("country-Province")));
				//DistricLoader myobj = new DistricLoader();
				
				//System.out.println(myobj2.getNumberfordis());
			  
				request.setAttribute("district", "true");
				request.setAttribute("province", request.getParameter("country-Province"));
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddCampaignCity.jsp");
				requestDispatcher.include(request, response);
			}
			
			else if("State".equals(request.getParameter("hiddens"))) {
				System.out.println("it runs");
				PreparedStatement stmt1 = con.prepareStatement("UPDATE Campaign_Details SET State = ? Where Campain_name = ? && Date = ?");
				stmt1.setInt(1, Integer.parseInt(request.getParameter("country-state")));
				stmt1.setString(2, nameString);
				stmt1.setString(3, dateString);
				stmt1.executeUpdate();
				stmt1.close();
				System.out.println(request.getParameter("country-state"));
				//Loader myobj2 = new Loader();
			  CityLoader.setNumber(Integer.parseInt(request.getParameter("country-state")));
				//DistricLoader myobj = new DistricLoader();
				
				//System.out.println(myobj2.getNumberfordis());
			  
				request.setAttribute("district", "true");
				request.setAttribute("city", "true");
				request.setAttribute("province", request.getParameter("hiddenP1"));
				request.setAttribute("state", request.getParameter("country-state"));
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddCampaignCity.jsp");
				requestDispatcher.include(request, response);
			}
			
			else if("City".equals(request.getParameter("hiddenc"))) {
				System.out.println("it runs");
				PreparedStatement stmt2 = con.prepareStatement("UPDATE Campaign_Details SET City = ? Where Campain_name = ? && Date = ?");
				stmt2.setInt(1, Integer.parseInt(request.getParameter("country-city")));
				stmt2.setString(2, nameString);
				stmt2.setString(3, dateString);
				stmt2.executeUpdate();
				stmt2.close();
				System.out.println(request.getParameter("country-state"));
				//Loader myobj2 = new Loader();
			  //CityLoader.setNumber(Integer.parseInt(request.getParameter("country-state")));
				//DistricLoader myobj = new DistricLoader();
				
				//System.out.println(myobj2.getNumberfordis());
			  
//				request.setAttribute("district", "true");
//				request.setAttribute("city", "true");
//				request.setAttribute("province", request.getParameter("hiddenP1"));
//				request.setAttribute("state", request.getParameter("country-state"));
				
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddCampaignCity.jsp");
				
				
				
				
				requestDispatcher.include(request, response);
				session.removeAttribute("name");
				session.removeAttribute("date");
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
