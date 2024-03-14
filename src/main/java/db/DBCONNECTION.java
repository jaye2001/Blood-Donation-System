package db;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection; 


import java.sql.DriverManager; 
import java.sql.SQLException; 


public class DBCONNECTION {

	public static Connection initializeDatabase() 
	        throws SQLException, ClassNotFoundException 
	    { 
	        // Initialize all the information regarding 
	        // Database Connection 
		String host, port, databaseName, userName, password;
        host = "mysql-16d8522a-greensuper924-d7af.a.aivencloud.com";
        port = "11299";
        databaseName = "defaultdb";
        userName = "avnadmin";
        password = "AVNS_j3voztLVFipG207G1bU";
	  
	        Class.forName("com.mysql.cj.jdbc.Driver"); 
	        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + 
	        		":" + port + "/" + databaseName + "?sslmode=require", userName, password); 
	        
	        return con; 
	    } 
	

}
