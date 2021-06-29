package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Chatmessage.Chatsocket;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class ClientFrame {

	private JFrame frame;
	private static JTextField txthost;
	private static JTextField txtport;
	private static JTextField txtmess;
    public static Chatsocket chatsocket ;
    public static  JTextPane txtpn ;
    public static JButton btnconn ;
    public static JButton bntsend ;
	/**
	 * Launch the application.
	 */
	public static void Client() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame window = new ClientFrame();
					window.frame.setVisible(true);
					
					connect();
					send();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbClient = new JLabel("Client");
		lbClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbClient.setHorizontalAlignment(SwingConstants.CENTER);
		lbClient.setBounds(198, 11, 54, 19);
		lbClient.setText("Xin chào "+ControllerLogin.username +"!");
		frame.getContentPane().add(lbClient);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 41, 414, 2);
		frame.getContentPane().add(separator);
		
		JLabel lbseverhost = new JLabel("Server Host");
		lbseverhost.setHorizontalAlignment(SwingConstants.CENTER);
		lbseverhost.setBounds(20, 54, 76, 14);
		frame.getContentPane().add(lbseverhost);
		
		txthost = new JTextField();
		txthost.setText("192.168.1.8");
		txthost.setBounds(93, 51, 86, 20);
		frame.getContentPane().add(txthost);
		txthost.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Port");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(198, 57, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtport = new JTextField();
		txtport.setText("9888");
		txtport.setBounds(254, 51, 46, 20);
		frame.getContentPane().add(txtport);
		txtport.setColumns(10);
		
		btnconn = new JButton("Start Chat");
		btnconn.setBounds(320, 50, 104, 23);
		frame.getContentPane().add(btnconn);
		
	    txtpn = new JTextPane();
		txtpn.setBounds(10, 93, 414, 170);
		frame.getContentPane().add(txtpn);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(25, 305, 58, 14);
		frame.getContentPane().add(lblMessage);
		
		txtmess = new JTextField();
		txtmess.setBounds(93, 302, 243, 20);
		frame.getContentPane().add(txtmess);
		txtmess.setColumns(10);
		
		bntsend = new JButton("Send");
		bntsend.setBounds(356, 301, 68, 23);
		frame.getContentPane().add(bntsend);
	}
public static void connect() {
	btnconn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
				int port = Integer.parseInt(txtport.getText());
				Socket socket;
				try {
					socket = new Socket(txthost.getText(),port);
					chatsocket =  new Chatsocket(socket, txtpn);
					txtpn.setText("Connected......");
				
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	});
	
}
public static void send() {
	bntsend.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(txtmess.getText().equals("")) {
				return ;
			}
			chatsocket.send(ControllerLogin.username+" :"+txtmess.getText());
		}
	});
}
}
