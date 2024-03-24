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

@WebServlet("/LabViewServlet")
public class LabViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<LabView> labViewList = new ArrayList<>();
        System.out.println("ABCD");
        

        Connection con;
       
        try {
        	
        	
        	con = DBCONNECTION.initializeDatabase();
        	
            PreparedStatement pstmt = null;
            ResultSet rs;
        	
            String sql = "SELECT * FROM Blood_Stock";
            pstmt = con.prepareStatement(sql);
            
            String sql1 = "SELECT bs.id, bs.NIC, bs.Date, bs.Status, bs.Location, d.Blood_Type " +
                    "FROM Donor d " +
                    "LEFT JOIN Blood_Stock bs ON bs.NIC = d.NIC";
            pstmt = con.prepareStatement(sql1);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                LabView labView = new LabView(
                        rs.getInt("id"),
                        rs.getString("NIC"),
                        rs.getDate("Date"),
					    rs.getString("Blood_Type"), 
                        rs.getString("Status"),
                        rs.getString("Location")
                );
                labViewList.add(labView);
            }
            System.out.println(labViewList);

            rs.close();
            pstmt.close();
            con.close();

            request.setAttribute("labViewList", labViewList);
            request.getRequestDispatcher("/LabApproval.jsp").forward(request, response);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error adding to Blood Stock: A donor with the provided NIC does not exist.");
        } 
        
    }
}
