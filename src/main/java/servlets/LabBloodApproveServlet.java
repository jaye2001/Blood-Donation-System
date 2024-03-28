package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import db.DBCONNECTION;

/**
 * Servlet implementation class LabBloodApproveServlet
 */
public class LabBloodApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public LabBloodApproveServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        Connection con;

		try {
            String id = request.getParameter("id");
            String status = request.getParameter("status");
            System.out.println(status);
            if (!status.equals("Approved") || !status.equals("Rejected")) throw new SQLException();
            
			con = DBCONNECTION.initializeDatabase();
			
			PreparedStatement pstmt = con.prepareStatement("UPDATE Blood_Stock SET Status = ? WHERE id = ?");
			pstmt.setString(1, status);
			pstmt.setString(2, id);
			
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		doGet(request, response);
	}

}
