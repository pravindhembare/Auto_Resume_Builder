package com.dypatil.autoresumebuilder.application;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutAndDeclaInto {

	JFrame AD;
	private JTextField us;
	private static JTextArea decl;
	private static JTextArea about;

	private static String userid;
	Connection conn;
	PreparedStatement pst;
	Statement statement;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AboutAndDeclaInto window = new AboutAndDeclaInto();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	public AboutAndDeclaInto() {
//		initialize();
//	}
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/resumebuilder", "root", "root");
			statement = conn.createStatement();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public AboutAndDeclaInto(String uid) {
		initialize();
		Connect();
		userid = uid;
	this.us.setText(uid);
	
	try {
		String sql = "select * from abo_dec_into where userid='" + userid + "'";
		ResultSet rs = statement.executeQuery(sql);
		if (rs.next()) {

			String un1 = rs.getString("about");
			String un2 = rs.getString("declaration");		
			decl.setText(un2);
			about.setText(un1);
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	}


	private void initialize() {
		AD = new JFrame();
		AD.setBounds(100, 100, 850, 550);
		AD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AD.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 413, 522);
		AD.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(29, 118, 360, 148);
		panel.add(lblNewLabel_2);
		
		JButton btnback = new JButton("..Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HobbiesAndSkillInfo info = new HobbiesAndSkillInfo(userid);
				info.HS.setVisible(true);
				AD.dispose();
				
			}
		});
		btnback.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnback.setBounds(423, 11, 70, 20);
		AD.getContentPane().add(btnback);
		
		us = new JTextField();
		us.setColumns(10);
		us.setBounds(738, 11, 86, 20);
		AD.getContentPane().add(us);
		
		JLabel lblPersonalInformation_1 = new JLabel("About");
		lblPersonalInformation_1.setForeground(Color.BLACK);
		lblPersonalInformation_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPersonalInformation_1.setBounds(510, 54, 160, 37);
		AD.getContentPane().add(lblPersonalInformation_1);
		
		JButton btnNext = new JButton("Next..");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rn1 = about.getText();
				String rn2 = decl.getText();
				
				
				
				try {					
					String sql = "select * from abo_dec_into where userid='" + userid + "'";
					ResultSet rs = statement.executeQuery(sql);
					if (rs.next()) {											
						try {													
							String sql1 = "update abo_dec_into set about = '" + rn1 + "', declaration = '" + rn2 + "' where userid = '" + userid + "'";
							int y = statement.executeUpdate(sql1);
							if (y == 1) {

								JOptionPane.showMessageDialog(null, "Information Update Succesfully");
								
								TempletChoosePage page = new TempletChoosePage(userid);
								page.Temp.setVisible(true);
								AD.dispose();

							} else {
								JOptionPane.showMessageDialog(null, "Please Insert Information");
							}

						} catch (Exception ex) {							
							ex.printStackTrace();
						}

						
					} else {
						
						try {							
							String sql1 = "insert into abo_dec_into values('" + userid +"','" + rn1 + "','" + rn2 + "')";
							int y = statement.executeUpdate(sql1);
							if (y == 1) {

								JOptionPane.showMessageDialog(null, "Information Inserted Succesfully");
								TempletChoosePage page = new TempletChoosePage(userid);
								page.Temp.setVisible(true);
								AD.dispose();
								
							} else {
								JOptionPane.showMessageDialog(null, "Please Insert Correct Information");
							}

						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Please Insert Correct Information");
						}
						
					}					

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNext.setBounds(714, 470, 110, 30);
		AD.getContentPane().add(btnNext);
		
		JLabel lblPersonalInformation_1_1 = new JLabel("Declaration");
		lblPersonalInformation_1_1.setForeground(Color.BLACK);
		lblPersonalInformation_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPersonalInformation_1_1.setBounds(510, 272, 160, 37);
		AD.getContentPane().add(lblPersonalInformation_1_1);
		
		about = new JTextArea();
		about.setBounds(501, 117, 279, 123);
		AD.getContentPane().add(about);
		
		decl = new JTextArea();
		decl.setBounds(510, 323, 279, 123);
		AD.getContentPane().add(decl);
	}

}
