package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControllerLogin {
	static String username ;
	public static void xulidangnhap() {
		Login.dangnhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				
					username = Login.textField.getText().toString().trim();
					String pass = Login.passwordField.getText().toString().trim();
					
				
					if(pass.isEmpty() && username.isEmpty()) {
						Login.lblNewLabel.setText(" Bạn chưa điền User Name và Password !");
					}else if(pass.isEmpty()) {
						Login.lblNewLabel.setText(" Bạn chưa điền Password !");
					}else if (username.isEmpty()) {
						Login.lblNewLabel.setText(" Bạn chưa điền UserName !");
					}else if(username!=null && pass!=null){
					     User.listuser();
					     for(int i = 0 ;i<User.users.size();i++) {
					    	 String userdb = User.users.get(i).getUsername();
					    	 String passdb = User.users.get(i).getPass();
					    	// System.out.println(userdb+" "+passdb);
					    	if(username.equals(userdb) && pass.equals(passdb)) {
					    	//	Login.lblNewLabel.setText(" Đăng nhập thành công !");
					    	    Login.frame.dispose();
					    	  ClientFrame.Client();
					    	
					    		break ;
					    	}
					    	Login.lblNewLabel.setText(" Đăng nhập thất bại !");
					     }
					 
					}
					
			
				}});	
		}
}
