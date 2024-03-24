package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import db.DBCONNECTION;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/BloodDonationServlet")
public class BloodDonationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String donorNIC = request.getParameter("donorNIC");
        String location = request.getParameter("location");
        String date = request.getParameter("date");
        String stock = "Donated"; // Since the button clicked is 'Donated'

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBCONNECTION.initializeDatabase();
            String sql = "INSERT INTO Blood_Stock (NIC, Date, Location, Stock) VALUES (?, ?, ?, ?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, donorNIC);
            pstmt.setString(2, date);
            pstmt.setString(3, location);
            pstmt.setString(4, stock);

            int result = pstmt.executeUpdate();

            if (result > 0) {
                request.setAttribute("successMessage", "The blood donation has been successfully recorded.");
            } else {
                request.setAttribute("errorMessage", "Unable to record the blood donation.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            request.setAttribute("errorMessage", "Database error: " + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        request.getRequestDispatcher("Donated_Place.jsp").forward(request, response);
    }
}
