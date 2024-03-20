package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBCONNECTION;

public class ProvinceLoader {
	

	
public List<Loader> getLoade() throws SQLException {
		
	List<Loader> loade = new ArrayList<Loader>();
	 Connection con;
		 try {
			con = DBCONNECTION.initializeDatabase();
			
			PreparedStatement st = con.prepareStatement("Select id,Pname_en from provinces");
			ResultSet rs = st.executeQuery();
			
			
			 
			while (rs.next()) {
				
				Loader loader = new Loader();
				loader.SetList(rs.getInt("id"), rs.getString("name_en"));
				loade.add(loader);
				//System.out.println(rs.getInt("id")+rs.getString("name_en"));
				
			}
			
			
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return loade;
		
	}
}
