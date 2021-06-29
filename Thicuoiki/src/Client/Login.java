package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
    public static Login frame  ;
	private JPanel contentPane;
	public static JTextField textField;
	public static JPasswordField passwordField;
	public static  JButton dangnhap ;
	public static JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void Login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
					ControllerLogin.xulidangnhap();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserLogin = new JLabel("User Login");
		lblUserLogin.setBounds(145, 11, 204, 80);
		lblUserLogin.setLabelFor(this);
		lblUserLogin.setIcon(new ImageIcon("E:\\Ảnh Livertorrard\\avarta.png"));
		lblUserLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserLogin.setForeground(Color.RED);
		lblUserLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblUserLogin);
		
		JLabel user = new JLabel("User Name :");
		user.setIcon(new ImageIcon("E:\\Ảnh Livertorrard\\icons8-name-26.png"));
		user.setHorizontalAlignment(SwingConstants.CENTER);
		user.setBounds(52, 175, 100, 25);
		contentPane.add(user);
		
		JLabel pass = new JLabel("Password :");
		pass.setIcon(new ImageIcon("E:\\Ảnh Livertorrard\\icons8-password-book-26.png"));
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.setBounds(52, 230, 100, 25);
		contentPane.add(pass);
		
		textField = new JTextField();
		textField.setBounds(175, 177, 200, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 232, 200, 25);
		contentPane.add(passwordField);
		
		Icon icon = new ImageIcon("E:\\Ảnh Livertorrard\\icons8-login-24.png");
	    dangnhap = new JButton(new ImageIcon("E:\\Ảnh Livertorrard\\icons8-login-24.png"));
		dangnhap.setBounds(275, 268, 30, 30);
		contentPane.add(dangnhap);
		
		JLabel Login = new JLabel("Login");
		Login.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Login.setBounds(210, 268, 40, 30);
		contentPane.add(Login);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 384, 464, 40);
		contentPane.add(lblNewLabel);
		
	}

}
