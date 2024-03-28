package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import db.DBCONNECTION;

@WebServlet("/UpdateDonorStatusServlet")
public class UpdateDonorStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateDonorStatusServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nic = request.getParameter("nic"); // Ensure this matches the 'name' attribute in your form
        String eligibility = request.getParameter("eligibility"); // The selected eligibility value
        String description = request.getParameter("description"); // The entered description

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBCONNECTION.initializeDatabase();
            String sql = "UPDATE Donor SET Status = ?, desc = ? WHERE NIC = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, eligibility);
            pstmt.setString(2, description);
            pstmt.setString(3, nic);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                // Handle the successful update case
                // For example, redirect to a success page or set a success message attribute
                response.sendRedirect("update_success.jsp"); // Redirect to a success page if you have one
            } else {
                // Handle the case where the NIC does not exist or no update was made
                // For example, set an error message attribute or redirect to an error page
                request.setAttribute("errorMessage", "No donor found with the provided NIC or no update needed.");
                request.getRequestDispatcher("Eligibility_Donor.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Handle potential exceptions
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Database error occurred while updating donor status.");
        } finally {
            // Clean up database resources
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
