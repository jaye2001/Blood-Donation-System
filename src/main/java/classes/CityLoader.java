package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import db.DBCONNECTION;

public class CityLoader {
	
	private static int number;

public static void setNumber (int num) {
	number = num;
	System.out.println(number);
}

//public int getNumber() {
//	return number;
//}

public List<Loader> getLoade() throws SQLException {
	
	System.out.println("run this");
	List<Loader> loade2 = new ArrayList<Loader>();
	
	 Connection con;
		 try {
			Loader myobj3 = new Loader();
			con = DBCONNECTION.initializeDatabase();
			//System.out.println("run this");
			PreparedStatement st = con.prepareStatement("Select id,Cname_en from cities where district_id = ?");
			st.setInt(1, number);
			ResultSet rs = st.executeQuery();
			//System.out.println(number);
			
			 
			while (rs.next()) {
				//System.out.println("run this");
				Loader loader2 = new Loader();
				loader2.SetList(rs.getInt("id"), rs.getString("Cname_en"));
				loade2.add(loader2);
				//System.out.println(rs.getInt("id")+rs.getString("name_en"));
				
			}
			
			
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return loade2;
		
	}
}