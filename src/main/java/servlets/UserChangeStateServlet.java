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
@WebServlet("/UserChangeStateServlet")
public class UserChangeStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		Connection con;
		HttpSession session = request.getSession();
	    String nicString = (String) session.getAttribute("nic");
	    
		
		try {
			con = DBCONNECTION.initializeDatabase();
			String valueString = request.getParameter("country-Province");
			//System.out.println(valueString);
			
			if("province".equals(request.getParameter("hiddenP"))) {
				PreparedStatement stmt = con.prepareStatement("UPDATE Donor SET ProvinceId = ? Where NIC = ?");
				stmt.setInt(1, Integer.parseInt(request.getParameter("country-Province")));
				stmt.setString(2, nicString);
				stmt.executeUpdate();
				stmt.close();
				//System.out.println("wada");
				//Loader myobj2 = new Loader();
			  DistricLoader.setNumber(Integer.parseInt(request.getParameter("country-Province")));
				//DistricLoader myobj = new DistricLoader();
				
				//System.out.println(myobj2.getNumberfordis());
			  
				request.setAttribute("district", "true");
				request.setAttribute("province", request.getParameter("country-Province"));
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Userchangestate.jsp");
				requestDispatcher.include(request, response);
			}
			
			else if("State".equals(request.getParameter("hiddens"))) {
				System.out.println("it runs");
				PreparedStatement stmt1 = con.prepareStatement("UPDATE Donor SET DistricId = ? Where NIC = ?");
				stmt1.setInt(1, Integer.parseInt(request.getParameter("country-state")));
				stmt1.setString(2, nicString);
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
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Userchangestate.jsp");
				requestDispatcher.include(request, response);
			}
			
			else if("City".equals(request.getParameter("hiddenc"))) {
				System.out.println("it runs");
				PreparedStatement stmt2 = con.prepareStatement("UPDATE Donor SET CityId = ? Where NIC = ?");
				stmt2.setInt(1, Integer.parseInt(request.getParameter("country-city")));
				stmt2.setString(2, nicString);
				stmt2.executeUpdate();
				stmt2.close();
				System.out.println(request.getParameter("country-city"));
				//Loader myobj2 = new Loader();
			  //CityLoader.setNumber(Integer.parseInt(request.getParameter("country-state")));
				//DistricLoader myobj = new DistricLoader();
				
				//System.out.println(myobj2.getNumberfordis());
			  
//				request.setAttribute("district", "true");
//				request.setAttribute("city", "true");
//				request.setAttribute("province", request.getParameter("hiddenP1"));
//				request.setAttribute("state", request.getParameter("country-state"));
				response.sendRedirect("UserprofileServlet");
				
				
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
