package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            
            // Insert into Person table
            String sqlPerson = "INSERT INTO Person (NIC, fname,lname, email, password, type,gender) VALUES (?, ?, ?, ?, ?,?,?)";
            pstmt = con.prepareStatement(sqlPerson);
            pstmt.setString(1, nic);
            pstmt.setString(2, fname);
            pstmt.setString(3, lname);
            pstmt.setString(4, email);
            pstmt.setString(5, password);
            pstmt.setString(6, type);
            pstmt.setString(7, "none");
            

            int rowAffectedPerson = pstmt.executeUpdate();
            
         
            
           
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
