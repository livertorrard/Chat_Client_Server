package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Chatmessage.Chatsocket;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Serverframe {

	public JFrame frame;
	private static JTextField txtport;
	private static JTextField txtsend;
    private static JButton bntlisten ;
    private static JTextPane txtmess ;
    private static Chatsocket chatsocket;
    public  static JButton bntsend ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Serverframe window = new Serverframe();
					window.frame.setVisible(true);
					listening();
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
	public Serverframe() {
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
		
		JLabel lbServer = new JLabel("Server");
		lbServer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbServer.setHorizontalAlignment(SwingConstants.CENTER);
		lbServer.setBounds(163, 11, 111, 19);
		frame.getContentPane().add(lbServer);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 414, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Port");
		lblNewLabel.setBounds(20, 49, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtport = new JTextField();
		txtport.setText("9888");
		txtport.setBounds(75, 46, 86, 20);
		frame.getContentPane().add(txtport);
		txtport.setColumns(10);
		
		bntlisten = new JButton("Listen");
		bntlisten.setBounds(331, 45, 76, 23);
		frame.getContentPane().add(bntlisten);
		
		txtmess = new JTextPane();
		txtmess.setBounds(10, 81, 414, 186);
		frame.getContentPane().add(txtmess);
		
		JLabel lblNewLabel_1 = new JLabel("Message");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 313, 72, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtsend = new JTextField();
		txtsend.setBounds(92, 310, 240, 20);
		frame.getContentPane().add(txtsend);
		txtsend.setColumns(10);
		
		bntsend = new JButton("Send");
		bntsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		bntsend.setBounds(361, 309, 63, 23);
		frame.getContentPane().add(bntsend);
	}
	public static void listening() {
		bntlisten.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					int port = Integer.parseInt(txtport.getText());
					ServerSocket serverSocket = new ServerSocket(port);
					Thread th =  new Thread() {
						public void run() {
							
							try {
								txtmess.setText(txtmess.getText()+"Listening........");
								Socket socket = serverSocket.accept();
								chatsocket = new Chatsocket(socket, txtmess);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
						
					};
					th.start();
					
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
				if(txtsend.getText().equals("")) {
					return ;
				}
				chatsocket.send("Server :" +txtsend.getText());
			}
		});

	}

}
