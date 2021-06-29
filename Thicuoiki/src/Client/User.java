package Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class User {
	public static List<User> users =  new ArrayList<>();	
	private String username ;
	private String pass ;
	public User(String username, String pass) {
		super();
		this.username = username;
		this.pass = pass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	//hàm listuser(): dùng để get dữ liệu từ mysql rồi sao đó lưu trữ vào trong một cái list để xử lí dữ liệu
	public static void listuser() {
		
		try {
			String sql = "SELECT * FROM user";
			Statement st = connect.getCN().createStatement();
			ResultSet rs = st.executeQuery(sql);
		
			while (rs.next()) {
			String userdb= rs.getString(2);
			String passdb = rs.getString(3);	
			users.add(new User(userdb, passdb));

			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
