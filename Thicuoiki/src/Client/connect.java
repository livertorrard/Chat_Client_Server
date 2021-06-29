package Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
	public static Connection getCN() throws ClassNotFoundException, SQLException {
		 final String url ="jdbc:mysql://localhost:3306/banhang" ;
		 final String user = "root";
		 final String password = "";
		 
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 
		return DriverManager.getConnection(url, user, password) ;
		  
		
		 
	 }
	 public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = getCN();
		
	} 
}
