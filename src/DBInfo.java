import java.sql.Connection;
import java.sql.DriverManager;


public class DBInfo {
	static Connection con;
	static 
	{
		//drivers
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/libmgmt","root","1234");
		}
		catch(Exception e){
			
		}
		
	}
	
}
