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

public class ExtraCirricularActInfo {

	JFrame ExtraCirActInfo;
	private JTextField us;
	private JTextField aa1;
	private JTextField aa2;
	private JTextField aa3;
	private static JTextArea dd1;
	private static JTextArea dd2;
	private static JTextArea dd3;

	
	private static String userid;
	Connection conn;
	PreparedStatement pst;
	Statement statement;
	ResultSet rs;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ExtraCirricularActInfo window = new ExtraCirricularActInfo();
//					window.ExtraCirActInfo.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	
//	public ExtraCirricularActInfo() {
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
	
	public ExtraCirricularActInfo(String uid) {
		initialize();
		Connect();
			userid = uid;
		this.us.setText(uid);
		
		try {						
			String sql = "select * from extra_cirru_act_info where userid='" + userid + "'";
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {

				String un1 = rs.getString("a1");
				String un2 = rs.getString("d1");
				String un3 = rs.getString("a2");
				String un4 = rs.getString("d2");
				String un5 = rs.getString("a3");
				String un6 =rs.getString("d3");			
				
				this.aa1.setText(un1);				
				this.aa2.setText(un3);				
				this.aa3.setText(un5);				
					dd1.setText(un2);
					dd2.setText(un4);
					dd3.setText(un6);							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	private void initialize() {
		ExtraCirActInfo = new JFrame();
		ExtraCirActInfo.setBounds(100, 100, 850, 550);
		ExtraCirActInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ExtraCirActInfo.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 413, 522);
		ExtraCirActInfo.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(29, 118, 360, 148);
		panel.add(lblNewLabel_2);
		
		JButton btnback = new JButton("..Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WorkExperienceInfo workExperienceInfo = new WorkExperienceInfo(userid);
				workExperienceInfo.WorkExInfo.setVisible(true);
				ExtraCirActInfo.dispose();
			}
		});
		btnback.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnback.setBounds(423, 11, 70, 20);
		ExtraCirActInfo.getContentPane().add(btnback);
		
		us = new JTextField();
		us.setColumns(10);
		us.setBounds(738, 11, 86, 20);
		ExtraCirActInfo.getContentPane().add(us);
		
		JLabel lblPersonalInformation_1 = new JLabel("Extra-Curricular Activity");
		lblPersonalInformation_1.setForeground(Color.BLACK);
		lblPersonalInformation_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPersonalInformation_1.setBounds(500, 42, 288, 37);
		ExtraCirActInfo.getContentPane().add(lblPersonalInformation_1);
		
		JLabel lblActivityName = new JLabel("Activity Name:");
		lblActivityName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblActivityName.setBounds(450, 115, 128, 25);
		ExtraCirActInfo.getContentPane().add(lblActivityName);
		
		aa1 = new JTextField();
		aa1.setColumns(10);
		aa1.setBounds(611, 118, 213, 20);
		ExtraCirActInfo.getContentPane().add(aa1);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescription.setBounds(450, 151, 128, 25);
		ExtraCirActInfo.getContentPane().add(lblDescription);
		
		JLabel lblCompanyname_1 = new JLabel("Activity Name:");
		lblCompanyname_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompanyname_1.setBounds(450, 230, 128, 25);
		ExtraCirActInfo.getContentPane().add(lblCompanyname_1);
		
		aa2 = new JTextField();
		aa2.setColumns(10);
		aa2.setBounds(611, 233, 213, 20);
		ExtraCirActInfo.getContentPane().add(aa2);
		
		JLabel lblInstituteName_1 = new JLabel("Description:");
		lblInstituteName_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInstituteName_1.setBounds(450, 266, 128, 25);
		ExtraCirActInfo.getContentPane().add(lblInstituteName_1);
		
		JLabel lblActivityName_1 = new JLabel("Activity Name:");
		lblActivityName_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblActivityName_1.setBounds(450, 345, 128, 25);
		ExtraCirActInfo.getContentPane().add(lblActivityName_1);
		
		aa3 = new JTextField();
		aa3.setColumns(10);
		aa3.setBounds(611, 348, 213, 20);
		ExtraCirActInfo.getContentPane().add(aa3);
		
		JLabel lblDescription_1 = new JLabel("Description:");
		lblDescription_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescription_1.setBounds(450, 381, 128, 25);
		ExtraCirActInfo.getContentPane().add(lblDescription_1);
		
		 dd1 = new JTextArea();
		dd1.setWrapStyleWord(true);
		dd1.setToolTipText("");
		dd1.setBounds(611, 149, 213, 58);
		ExtraCirActInfo.getContentPane().add(dd1);
		
		 dd2 = new JTextArea();
		dd2.setWrapStyleWord(true);
		dd2.setToolTipText("");
		dd2.setBounds(611, 264, 213, 58);
		ExtraCirActInfo.getContentPane().add(dd2);
		
		dd3 = new JTextArea();
		dd3.setWrapStyleWord(true);
		dd3.setBounds(611, 379, 213, 58);
		ExtraCirActInfo.getContentPane().add(dd3);
		
		JButton btnNext = new JButton("Next..");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rn1 = aa1.getText();
				String rn2 = dd1.getText();
				String rn3 = aa2.getText();
				String rn4 = dd2.getText();
				String rn5 = aa3.getText();
				String rn6 = dd3.getText();				
				
				
				try {					
					String sql = "select * from extra_cirru_act_info where userid='" + userid + "'";
					ResultSet rs = statement.executeQuery(sql);
					if (rs.next()) {											
						try {													
							String sql1 = "update extra_cirru_act_info set a1 = '" + rn1 + "', d1 = '" + rn2 + "', a2 = '" + rn3+ "', d2 = '" + rn4 + "'"
																+ ",a3 = '" + rn5 + "', d3 = '" + rn6 + "' where userid = '" + userid + "'";
							int y = statement.executeUpdate(sql1);
							if (y == 1) {

								JOptionPane.showMessageDialog(null, "Information Update Succesfully");
								
								ProjectsInfo info = new ProjectsInfo(userid);
								info.ProInfo.setVisible(true);
								ExtraCirActInfo.dispose();

							} else {
								JOptionPane.showMessageDialog(null, "Please Insert Information");
							}

						} catch (Exception ex) {							
							ex.printStackTrace();
						}

						
					} else {
						
						try {							
							String sql1 = "insert into extra_cirru_act_info values('" + userid +"','" + rn1 + "','" + rn2 + "','" + rn3+ "','" + rn4 + "',"
									+ "'" + rn5 + "','" + rn6 + "')";
							int y = statement.executeUpdate(sql1);
							if (y == 1) {

								JOptionPane.showMessageDialog(null, "Information Inserted Succesfully");
																		
								ProjectsInfo info = new ProjectsInfo(userid);
								info.ProInfo.setVisible(true);
								ExtraCirActInfo.dispose();
								
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
		btnNext.setBounds(714, 457, 110, 30);
		ExtraCirActInfo.getContentPane().add(btnNext);
	}
}
