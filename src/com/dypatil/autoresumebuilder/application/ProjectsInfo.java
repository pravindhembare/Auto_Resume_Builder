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
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProjectsInfo {

	JFrame ProInfo;
	private JTextField us;
	private JTextField pr1;
	private JTextField du1;
	private JTextField pr2;
	private JTextField du2;
	private static JTextArea dc1;
	private static JTextArea dc2;

	private static String userid;
	Connection conn;
	PreparedStatement pst;
	Statement statement;
	ResultSet rs;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ProjectsInfo window = new ProjectsInfo();
//					window.ProInfo.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	
//	public ProjectsInfo() {
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

	public ProjectsInfo(String uid) {
		initialize();
		Connect();
		userid = uid;
		this.us.setText(uid);

		try {
			String sql = "select * from project_info where userid='" + userid + "'";
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {

				String un1 = rs.getString("name1");
				String un2 = rs.getString("duration1");
				String un3 = rs.getString("description1");
				String un4 = rs.getString("name2");
				String un5 = rs.getString("duration2");
				String un6 = rs.getString("description2");

				this.pr1.setText(un1);
				this.du1.setText(un2);
				dc1.setText(un3);
				this.pr2.setText(un4);
				this.du2.setText(un5);
				dc2.setText(un6);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	

	private void initialize() {
		ProInfo = new JFrame();
		ProInfo.setBounds(100, 100, 850, 550);
		ProInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ProInfo.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 413, 522);
		ProInfo.getContentPane().add(panel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ProjectsInfo.class.getResource("/images/laptop5.jpg")));
		lblNewLabel_2.setBounds(29, 118, 360, 148);
		panel.add(lblNewLabel_2);

		JButton btnback = new JButton("..Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExtraCirricularActInfo actInfo = new ExtraCirricularActInfo(userid);
				actInfo.ExtraCirActInfo.setVisible(true);
				ProInfo.dispose();				
			}
		});
		btnback.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnback.setBounds(423, 11, 70, 20);
		ProInfo.getContentPane().add(btnback);

		us = new JTextField();
		us.setColumns(10);
		us.setBounds(738, 11, 86, 20);
		ProInfo.getContentPane().add(us);

		JLabel lblPersonalInformation_1 = new JLabel("Projects Information");
		lblPersonalInformation_1.setForeground(Color.BLACK);
		lblPersonalInformation_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPersonalInformation_1.setBounds(519, 53, 213, 37);
		ProInfo.getContentPane().add(lblPersonalInformation_1);

		JButton btnNext = new JButton("Next..");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rn1 = pr1.getText();
				String rn2 = du1.getText();
				String rn3 = dc1.getText();
				String rn4 = pr2.getText();
				String rn5 = du2.getText();
				String rn6 = dc2.getText();				
				
				
				try {					
					String sql = "select * from project_info where userid='" + userid + "'";
					ResultSet rs = statement.executeQuery(sql);
					if (rs.next()) {											
						try {													
							String sql1 = "update project_info set name1 = '" + rn1 + "', duration1 = '" + rn2 + "', description1 = '" + rn3+ "', name2 = '" + rn4 + "'"
																+ ",duration2 = '" + rn5 + "', description2 = '" + rn6 + "' where userid = '" + userid + "'";
							int y = statement.executeUpdate(sql1);
							if (y == 1) {

								JOptionPane.showMessageDialog(null, "Information Update Succesfully");
								
								HobbiesAndSkillInfo hobbiesAndSkillInfo = new HobbiesAndSkillInfo(userid);
								hobbiesAndSkillInfo.HS.setVisible(true);
								ProInfo.dispose();

							} else {
								JOptionPane.showMessageDialog(null, "Please Insert Information");
							}

						} catch (Exception ex) {							
							ex.printStackTrace();
						}

						
					} else {
						
						try {							
							String sql1 = "insert into project_info values('" + userid +"','" + rn1 + "','" + rn2 + "','" + rn3+ "','" + rn4 + "',"
									+ "'" + rn5 + "','" + rn6 + "')";
							int y = statement.executeUpdate(sql1);
							if (y == 1) {

								JOptionPane.showMessageDialog(null, "Information Inserted Succesfully");
									HobbiesAndSkillInfo hobbiesAndSkillInfo = new HobbiesAndSkillInfo(userid);
									hobbiesAndSkillInfo.HS.setVisible(true);
									ProInfo.dispose();
								
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
		btnNext.setBounds(714, 448, 110, 30);
		ProInfo.getContentPane().add(btnNext);

		JLabel lblProjectName = new JLabel("Project Name:");
		lblProjectName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProjectName.setBounds(450, 120, 128, 25);
		ProInfo.getContentPane().add(lblProjectName);

		pr1 = new JTextField();
		pr1.setColumns(10);
		pr1.setBounds(611, 123, 213, 20);
		ProInfo.getContentPane().add(pr1);

		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescription.setBounds(450, 192, 128, 25);
		ProInfo.getContentPane().add(lblDescription);

		du1 = new JTextField();
		du1.setColumns(10);
		du1.setBounds(611, 160, 160, 17);
		ProInfo.getContentPane().add(du1);

		JLabel lblYearOfPassout_1_1_1 = new JLabel("Duration:");
		lblYearOfPassout_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYearOfPassout_1_1_1.setBounds(450, 156, 128, 25);
		ProInfo.getContentPane().add(lblYearOfPassout_1_1_1);

		dc1 = new JTextArea();
		dc1.setBounds(611, 193, 213, 56);
		ProInfo.getContentPane().add(dc1);

		JLabel lblProjectName_1 = new JLabel("Project Name:");
		lblProjectName_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProjectName_1.setBounds(450, 283, 128, 25);
		ProInfo.getContentPane().add(lblProjectName_1);

		pr2 = new JTextField();
		pr2.setColumns(10);
		pr2.setBounds(611, 286, 213, 20);
		ProInfo.getContentPane().add(pr2);

		JLabel lblDescription_1 = new JLabel("Description:");
		lblDescription_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescription_1.setBounds(450, 355, 128, 25);
		ProInfo.getContentPane().add(lblDescription_1);

		du2 = new JTextField();
		du2.setColumns(10);
		du2.setBounds(611, 323, 160, 17);
		ProInfo.getContentPane().add(du2);

		JLabel lblYearOfPassout_1_1_1_1 = new JLabel("Duration:");
		lblYearOfPassout_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYearOfPassout_1_1_1_1.setBounds(450, 319, 128, 25);
		ProInfo.getContentPane().add(lblYearOfPassout_1_1_1_1);

		dc2 = new JTextArea();
		dc2.setBounds(611, 356, 213, 56);
		ProInfo.getContentPane().add(dc2);
	}

}
