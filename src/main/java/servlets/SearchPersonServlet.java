package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import classes.LabView;
import db.DBCONNECTION;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SearchPersonServlet")
public class SearchPersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nic = request.getParameter("searchNIC");

        // Initialize variables for database connection
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Initialize your database connection here
            con = DBCONNECTION.initializeDatabase();
            String sql = "SELECT NIC, CONCAT(Fname, ' ', Lname) AS FullName, Email FROM Person WHERE NIC = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, nic);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Set attributes to be accessed by the JSP page
                request.setAttribute("nic", rs.getString("NIC"));
                request.setAttribute("name", rs.getString("FullName"));
                request.setAttribute("email", rs.getString("Email"));
            } else {
                request.setAttribute("errorMessage", "No records found for the provided NIC.");
            }

            // Forward request to the JSP page
            request.getRequestDispatcher("Eligibility_Donor.jsp").forward(request, response);
        } catch (Exception e) {
            // Handle potential exceptions
            throw new ServletException("Error retrieving person data", e);
        } finally {
            // Clean up database resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}