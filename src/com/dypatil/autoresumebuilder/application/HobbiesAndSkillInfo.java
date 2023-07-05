package com.dypatil.autoresumebuilder.application;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HobbiesAndSkillInfo {

	JFrame HS;
	private JTextField us;
	private JTextField h1;
	private JTextField h2;
	private JTextField h3;
	private JTextField h4;
	private JTextField s1;
	private JTextField s2;
	private JTextField s3;
	private JTextField s4;

	private static String userid;
	Connection conn;
	PreparedStatement pst;
	Statement statement;


//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HobbiesAndSkillInfo window = new HobbiesAndSkillInfo();
//					window.HS.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//
//	public HobbiesAndSkillInfo() {
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
	
	public HobbiesAndSkillInfo(String uid) {
		initialize();
		Connect();
		userid = uid;
	this.us.setText(uid);
	
	try {						
		String sql = "select * from hobbies_info where userid='" + userid + "'";
		ResultSet rs = statement.executeQuery(sql);
		if (rs.next()) {

			String un1 = rs.getString("hb1");
			String un2 = rs.getString("hb2");
			String un3 = rs.getString("hb3");
			String un4 = rs.getString("hb4");
	
			
			this.h1.setText(un1);				
			this.h2.setText(un2);				
			this.h3.setText(un3);		
			this.h4.setText(un4);										
		}
		
		String sql1 = "select * from skill_info where userid='" + userid + "'";
		ResultSet rs1 = statement.executeQuery(sql1);
		if (rs1.next()) {

			String un5 = rs1.getString("sk1");
			String un6 = rs1.getString("sk2");
			String un7 = rs1.getString("sk3");
			String un8 = rs1.getString("sk4");
	
			
			this.s1.setText(un5);				
			this.s2.setText(un6);				
			this.s3.setText(un7);		
			this.s4.setText(un8);												
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	}
	
	private void initialize() {
		HS = new JFrame();
		HS.setBounds(100, 100, 850, 550);
		HS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HS.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 413, 522);
		HS.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(HobbiesAndSkillInfo.class.getResource("/images/ok laptop1.png")));
		lblNewLabel_2.setBounds(29, 118, 360, 148);
		panel.add(lblNewLabel_2);
		
		JButton btnback = new JButton("..Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProjectsInfo info = new ProjectsInfo(userid);
				info.ProInfo.setVisible(true);
				HS.dispose();					
				
			}
		});
		btnback.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnback.setBounds(423, 11, 70, 20);
		HS.getContentPane().add(btnback);
		
		us = new JTextField();
		us.setColumns(10);
		us.setBounds(738, 11, 86, 20);
		HS.getContentPane().add(us);
		
		JLabel lblPersonalInformation_1 = new JLabel("Your Hobbies");
		lblPersonalInformation_1.setForeground(Color.BLACK);
		lblPersonalInformation_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPersonalInformation_1.setBounds(539, 52, 160, 37);
		HS.getContentPane().add(lblPersonalInformation_1);
		
		JButton btnNext = new JButton("Next..");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rn1 = h1.getText();
				String rn2 = h2.getText();
				String rn3 = h3.getText();
				String rn4 = h4.getText();
				String rn5 = s1.getText();
				String rn6 = s2.getText();
				String rn7 = s3.getText();
				String rn8 = s4.getText();
				
				
				try {					
					String sql = "select * from hobbies_info where userid='" + userid + "'";
					ResultSet rs = statement.executeQuery(sql);
					if (rs.next()) {											
						try {													
							String sql1 = "update hobbies_info set hb1 = '" + rn1 + "', hb2 = '" + rn2 + "', hb3 = '" + rn3+ "', hb4 = '" + rn4 + "' where userid = '" + userid + "'";
							String sql2 = "update skill_info set sk1 = '" + rn1 + "', sk2 = '" + rn2 + "', sk3 = '" + rn3+ "', sk4 = '" + rn4 + "' where userid = '" + userid + "'";
							int y = statement.executeUpdate(sql1);
							int z = statement.executeUpdate(sql2);
							if (y == 1 && z == 1) {

								JOptionPane.showMessageDialog(null, "Information Update Succesfully");
								AboutAndDeclaInto declaInto = new AboutAndDeclaInto(userid);
								declaInto.AD.setVisible(true);
								HS.dispose();

							} else {
								JOptionPane.showMessageDialog(null, "Please Insert Information");
							}

						} catch (Exception ex) {							
							ex.printStackTrace();
						}

						
					} else {
						
						try {							
							String sql1 = "insert into hobbies_info values('" + userid +"','" + rn1 + "','" + rn2 + "','" + rn3+ "','" + rn4 + "')";
							int y = statement.executeUpdate(sql1);
							String sql2 = "insert into skill_info values('" + userid +"','" + rn5 + "','" + rn6 + "','" + rn7 + "','" + rn8 + "')";							
							int z = statement.executeUpdate(sql2);
							if (y == 1  && z == 1) {

								JOptionPane.showMessageDialog(null, "Information Inserted Succesfully");
																									
								AboutAndDeclaInto declaInto = new AboutAndDeclaInto(userid);
								declaInto.AD.setVisible(true);
								HS.dispose();
								
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
		HS.getContentPane().add(btnNext);
		
		h1 = new JTextField();
		h1.setColumns(10);
		h1.setBounds(485, 116, 160, 20);
		HS.getContentPane().add(h1);
		
		h2 = new JTextField();
		h2.setColumns(10);
		h2.setBounds(510, 147, 160, 20);
		HS.getContentPane().add(h2);
		
		h3 = new JTextField();
		h3.setColumns(10);
		h3.setBounds(549, 180, 160, 20);
		HS.getContentPane().add(h3);
		
		h4 = new JTextField();
		h4.setColumns(10);
		h4.setBounds(578, 215, 160, 20);
		HS.getContentPane().add(h4);
		
		JLabel lblPersonalInformation_1_1 = new JLabel("Your Skills");
		lblPersonalInformation_1_1.setForeground(Color.BLACK);
		lblPersonalInformation_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPersonalInformation_1_1.setBounds(549, 265, 160, 37);
		HS.getContentPane().add(lblPersonalInformation_1_1);
		
		s1 = new JTextField();
		s1.setColumns(10);
		s1.setBounds(485, 320, 160, 20);
		HS.getContentPane().add(s1);
		
		s2 = new JTextField();
		s2.setColumns(10);
		s2.setBounds(510, 351, 160, 20);
		HS.getContentPane().add(s2);
		
		s3 = new JTextField();
		s3.setColumns(10);
		s3.setBounds(549, 384, 160, 20);
		HS.getContentPane().add(s3);
		
		s4 = new JTextField();
		s4.setColumns(10);
		s4.setBounds(578, 419, 160, 20);
		HS.getContentPane().add(s4);
	}

}
