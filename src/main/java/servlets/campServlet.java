package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.http.Part;

import db.DBCONNECTION;

/**
 * Servlet implementation class campServlet
 */
@WebServlet("/campRegister")
@MultipartConfig
public class campServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public campServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		
		String date = request.getParameter("date");
		String STime = request.getParameter("STime");
		String FTime = request.getParameter("FTime");
		String organizer = request.getParameter("organizer");
		String bloodGroup = request.getParameter("bloodGroup");
		String description = request.getParameter("description");
		
		Part file=request.getPart("image");
		String imageFileName=file.getSubmittedFileName();
		String uploadPath="C:/Users/Administor/Desktop/cgp NEWWW/Blood-Donation-System/src/main/webapp/images/" + imageFileName;
		
		try {
		FileOutputStream fos=new FileOutputStream(uploadPath);
		InputStream is=file.getInputStream();
		
		byte[] data=new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher dispatcher = null;
		Connection con;
		
		try {
			
			
			
			con = DBCONNECTION.initializeDatabase();
			PreparedStatement pst = con.prepareStatement("insert into Campaign_Details(Campain_name,location,Date,STime,FTime,Organizers,MBloodGroup,Image,Description) values(?,?,?,?,?,?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2, location);
			
			pst.setString(3, date);
			pst.setString(4, STime);
			pst.setString(5, FTime);
			pst.setString(6, organizer);
			pst.setString(7, bloodGroup);
			pst.setString(8, imageFileName);
			pst.setString(9, description);
			
			int rowCount = pst.executeUpdate();
			
			dispatcher = request.getRequestDispatcher("/AddCampaignCity.jsp");
			
			if (rowCount > 0) {
				request.setAttribute("status", "success");
				
			}else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);
			
			HttpSession session = request.getSession();
		    session.setAttribute("name", request.getParameter("name") );
		    session.setAttribute("date", request.getParameter("date") );
			
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		

		
	}

}


