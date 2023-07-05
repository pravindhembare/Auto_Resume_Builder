package com.dypatil.autoresumebuilder.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class HomePage {

	JFrame HomePage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.HomePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		HomePage = new JFrame();
		HomePage.getContentPane().setBackground(Color.GRAY);
		HomePage.setBackground(new Color(255, 255, 255));
		HomePage.setBounds(100, 100, 850, 550);
		HomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HomePage.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("   Auto Resume Builder");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(434, 45, 314, 47);
		HomePage.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Create an account...");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(474, 160, 192, 31);
		HomePage.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Already have an account...");
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(474, 275, 232, 31);
		HomePage.getContentPane().add(lblNewLabel_1_1);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInPage logInPage = new LogInPage();
				logInPage.LogInPage.setVisible(true);
				HomePage.dispose();
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogIn.setBounds(638, 327, 110, 30);
		HomePage.getContentPane().add(btnLogIn);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 413, 522);
		HomePage.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(HomePage.class.getResource("/images/laptop1.jpg")));
		lblNewLabel_2.setBounds(29, 118, 360, 148);
		panel.add(lblNewLabel_2);

		JButton btnLogIn_1 = new JButton("Sign Up");
		btnLogIn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage mainPage = new MainPage();
				mainPage.MainPage.setVisible(true);
				HomePage.dispose();
			}
		});
		btnLogIn_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogIn_1.setBounds(638, 213, 110, 30);
		HomePage.getContentPane().add(btnLogIn_1);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}
}
