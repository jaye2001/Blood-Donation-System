package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import db.DBCONNECTION;
import thirdparty.*;

/**
 * Servlet implementation class AddAdminServlet
 */
@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection con = null;
        PreparedStatement pstmt = null;

        String fname = request.getParameter("adminFName");
        String lname = request.getParameter("adminLName");
        String email = request.getParameter("adminEmail");
        String password = request.getParameter("adminPassword");
        String nic = request.getParameter("adminNIC"); 
        String type = "admin";
        String mobile = request.getParameter("adminMobile");

        try {
            con = DBCONNECTION.initializeDatabase();
            
            String dateString = "2004-06-22";
				
			
			
			
	        
	        
			
			
			
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            
            // Insert into Person table
            String sqlPerson = "INSERT INTO Person (NIC, fname,lname, email, password, type,gender, DOB) VALUES (?, ?, ?, ?, ?,?,?,?)";
            pstmt = con.prepareStatement(sqlPerson);
            pstmt.setString(1, nic);
            pstmt.setString(2, fname);
            pstmt.setString(3, lname);
            pstmt.setString(4, email);
            pstmt.setString(5, password);
            pstmt.setString(6, type);
            pstmt.setString(7, "none");
            pstmt.setDate(8, sqlDate);
            

            int rowAffectedPerson = pstmt.executeUpdate();
            
            PreparedStatement statement4 = con.prepareStatement("insert into Donor (NIC,Blood_Type,weight,Status,ProvinceId,DistricId,CityId) values (?,?,?,?,?,?,?)");
			statement4.setString(1, nic);
			statement4.setString(2, "nul");
			statement4.setInt(3, 0);
			statement4.setString(4, "admin");
			statement4.setInt(5, 1);
			statement4.setInt(6, 5);
			statement4.setInt(7, 346);
			
			statement4.executeUpdate();
			statement4.close();
            
           
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Login.jsp");
 	    	
 			requestDispatcher.include(request, response);

        } catch (SQLException e) {
            out.println("<p>Error adding admin: " + e.getMessage() + "</p>");
            e.printStackTrace();
        } catch (Exception e) {
            out.println("<p>Exception: " + e.getMessage() + "</p>");
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) 
                  con.close();
            } catch (SQLException e) {
                out.println("<p>Exception on closing: " + e.getMessage() + "</p>");
            }
        }
    }
}
