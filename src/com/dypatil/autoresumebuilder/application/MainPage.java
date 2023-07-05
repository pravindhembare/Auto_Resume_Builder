package com.dypatil.autoresumebuilder.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainPage {

	JFrame MainPage;
	private JTextField fname;
	private JTextField lname;
	private JTextField email;
	private JTextField phoneno;
	private JTextField textField_4;
	private JTextField password;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.MainPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MainPage = new JFrame();
		MainPage.setBounds(100, 100, 850, 550);
		MainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPage.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ffname=fname.getText();
				String llname=lname.getText();
				String eemail=email.getText();
				String pphoneNo=phoneno.getText();
				String uusername=username.getText();
				String ppassword=password.getText();
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resumebuilder","root","root");
				Statement statement=con.createStatement();
				String sql="insert into registration values('" + ffname + "','" + llname + "','" + eemail + "','" + pphoneNo + "','" + uusername + "','" + ppassword+ "')";
				int x=statement.executeUpdate(sql);
				if(x==1) {

				JOptionPane.showMessageDialog(null, "Registration Successfully");
								
				}
				else{
					JOptionPane.showMessageDialog(null, "This userid is already exist");
				}
				}				
				catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "This userid is already exist");
				}
			}
		});
		btnNewButton.setBounds(598, 402, 110, 30);
		MainPage.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back..");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage homePage =new HomePage();
				homePage.HomePage.setVisible(true);
				MainPage.dispose();
			}
		});
		btnBack.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnBack.setBounds(482, 459, 70, 20);
		MainPage.getContentPane().add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 413, 533);
		MainPage.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainPage.class.getResource("/images/laptop2.jpg")));
		lblNewLabel_2.setBounds(29, 118, 360, 148);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Auto Resume Builder");
		lblNewLabel.setBounds(281, 49, 223, 37);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBounds(500, 135, 263, 256);
		MainPage.getContentPane().add(panel);
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("First Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 22, 79, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email Id :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(10, 94, 79, 25);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Phone no. :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(10, 130, 79, 25);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Password :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1.setBounds(10, 194, 79, 25);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Retype Password :");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 220, 119, 25);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 58, 79, 25);
		panel.add(lblNewLabel_1_1);
		
		fname = new JTextField();
		fname.setBounds(116, 25, 137, 20);
		panel.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(116, 61, 137, 20);
		panel.add(lname);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(116, 97, 137, 20);
		panel.add(email);
		
		phoneno = new JTextField();
		phoneno.setColumns(10);
		phoneno.setBounds(116, 133, 137, 20);
		panel.add(phoneno);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(116, 189, 137, 20);
		panel.add(textField_4);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(126, 223, 127, 20);
		panel.add(password);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Username");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(10, 158, 79, 25);
		panel.add(lblNewLabel_1_1_2);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(116, 164, 137, 20);
		panel.add(username);
		
		JLabel lblNewLabel_3 = new JLabel("   Auto Resume Builder");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3.setBounds(472, 37, 314, 47);
		MainPage.getContentPane().add(lblNewLabel_3);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
