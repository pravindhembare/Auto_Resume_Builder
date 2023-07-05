package com.dypatil.autoresumebuilder.application;

import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LogInPage {

	JFrame LogInPage;
	private JTextField user;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInPage window = new LogInPage();
					window.LogInPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogInPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LogInPage = new JFrame();
		LogInPage.setBounds(100, 100, 850, 550);
		LogInPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LogInPage.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Auto Resume Builder");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(515, 50, 223, 37);
		LogInPage.getContentPane().add(lblNewLabel);

		JButton btnBack = new JButton("Back..");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage homePage = new HomePage();
				homePage.HomePage.setVisible(true);
				LogInPage.dispose();

			}
		});
		btnBack.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnBack.setBounds(515, 384, 70, 20);
		LogInPage.getContentPane().add(btnBack);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Log In",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(515, 124, 261, 151);
		LogInPage.getContentPane().add(panel);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Password :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1.setBounds(10, 94, 79, 25);
		panel.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 58, 79, 25);
		panel.add(lblNewLabel_1_1);

		user = new JTextField();
		user.setColumns(10);
		user.setBounds(116, 61, 137, 20);
		panel.add(user);

		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(116, 97, 137, 20);
		panel.add(pass);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resumebuilder", "root",
							"root");
					Statement statement = con.createStatement();
					String sql = "select * from registration where username='" + user.getText() + "' and password='"
							+ pass.getText().toString() + "'";
					ResultSet rs = statement.executeQuery(sql);
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Login Successfully");

						String uid = rs.getString("username");
						PersonalInfo personalInfo = new PersonalInfo(uid);
						personalInfo.PersonalInfo.setVisible(true);
						LogInPage.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect username and password");
					}
					con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnLogIn.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnLogIn.setBounds(551, 315, 110, 30);
		LogInPage.getContentPane().add(btnLogIn);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 413, 533);
		LogInPage.getContentPane().add(panel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LogInPage.class.getResource("/images/laptop5.jpg")));
		lblNewLabel_2.setBounds(29, 118, 360, 148);
		panel_1.add(lblNewLabel_2);
	}
}
