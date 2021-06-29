package Chatmessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextPane;

public class Chatsocket {
private Socket socket ;
private JTextPane txtMessage ;
private PrintWriter out ;
private BufferedReader reader ;
public Chatsocket(Socket socket, JTextPane txtMessage) throws IOException {
	this.socket = socket;
	this.txtMessage = txtMessage;
	out = new PrintWriter(socket.getOutputStream());
	reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    receive();
}
private void receive() {
	Thread th = new Thread() {
	public void run() {
		while(true) {
			try {
				String line = reader.readLine();
				if(line != null) {
					txtMessage.setText(txtMessage.getText()+"\n"+line);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}	
	};
	th.start();
}
public void send(String msg) {
	String current = txtMessage.getText();
	txtMessage.setText(current+"\n"+msg);
	out.println(msg);
	out.flush();
}
public void close() {
	
	try {
		out.close();
		reader.close();
		socket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
