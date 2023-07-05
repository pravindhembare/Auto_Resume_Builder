package com.dypatil.autoresumebuilder.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoursesInfo {

	 JFrame CoursesInfo;
	private JTextField us;
	private JTextField cc1;
	private JTextField ii1;
	private JTextField yy1;
	private JTextField cc2;
	private JTextField ii2;
	private JTextField yy2;
	private JTextField cc3;
	private JTextField ii3;
	private JTextField yy3;
	
	String uid;
	Connection conn;
	PreparedStatement pst;
	Statement statement;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoursesInfo window = new CoursesInfo();
					window.CoursesInfo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/resumebuilder", "root", "root");
			statement = conn.createStatement();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * Create the application.
	 */
	public CoursesInfo() {
		initialize();
	}
	
	public CoursesInfo(String uid) {
		initialize();
		Connect();
		this.us.setText(uid);
		
		try {						
			String sql = "select * from courses_info where userid='" + us.getText() + "'";
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {

				String un1 = rs.getString("c1");
				String un2 = rs.getString("i1");
				String un3 = rs.getString("y1");
				String un4 = rs.getString("c2");
				String un5 = rs.getString("i2");
				String un6 =rs.getString("y2");
				String un7 = rs.getString("c3");
				String un8 = rs.getString("i3");
				String un9 = rs.getString("y3");
				
				this.cc1.setText(un1);
				this.ii1.setText(un2);
				this.yy1.setText(un3);
				this.cc2.setText(un4);
				this.ii2.setText(un5);
				this.yy2.setText(un6);
				this.cc3.setText(un7);
				this.ii3.setText(un8);
				this.yy3.setText(un9);			

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CoursesInfo = new JFrame();
		CoursesInfo.getContentPane().setBackground(Color.WHITE);
		CoursesInfo.setBounds(100, 100, 850, 550);
		CoursesInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CoursesInfo.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 413, 522);
		CoursesInfo.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(CoursesInfo.class.getResource("/images/laptop5.jpg")));
		lblNewLabel_2.setBounds(29, 118, 360, 148);
		panel.add(lblNewLabel_2);
		
		JButton btnback = new JButton("..Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AcademicInfo academicInfo = new AcademicInfo();
				academicInfo.AcademicInfo.setVisible(true);
				CoursesInfo.dispose();
			}
		});
		btnback.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnback.setBounds(423, 11, 70, 20);
		CoursesInfo.getContentPane().add(btnback);
		
		us = new JTextField();
		us.setColumns(10);
		us.setBounds(738, 11, 86, 20);
		CoursesInfo.getContentPane().add(us);
		
		JLabel lblPersonalInformation_1 = new JLabel("Courses Information");
		lblPersonalInformation_1.setForeground(Color.BLACK);
		lblPersonalInformation_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPersonalInformation_1.setBounds(501, 45, 236, 37);
		CoursesInfo.getContentPane().add(lblPersonalInformation_1);
		
		JButton btnNext = new JButton("Next..");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rn1 = cc1.getText();
				String rn2 = ii1.getText();
				String rn3 = yy1.getText();
				String rn4 = cc2.getText();
				String rn5 = ii2.getText();
				String rn6 = yy2.getText();
				String rn7 = cc3.getText();
				String rn8 = ii3.getText();
				String rn9 = yy3.getText();
				String rn = us.getText();
				
				
				try {					
					String sql = "select * from courses_info where userid='" + us.getText() + "'";
					ResultSet rs = statement.executeQuery(sql);
					if (rs.next()) {
						uid = rs.getString("userid");						
						try {													
							String sql1 = "update courses_info set c1 = '" + rn1 + "', i1 = '" + rn2 + "', y1 = '" + rn3+ "', c2 = '" + rn4 + "'"
																+ ",i2 = '" + rn5 + "', y2 = '" + rn6 + "', c3 = '" + rn7 + "', i3 = '" + rn8 + "' "
																+ ",y3 = '" + rn9 + "' where userid = '" + rn + "'";
							int y = statement.executeUpdate(sql1);
							if (y == 1) {

								JOptionPane.showMessageDialog(null, "Information Update Succesfully");
								
								WorkExperienceInfo workExperienceInfo = new WorkExperienceInfo(uid);
								workExperienceInfo.WorkExInfo.setVisible(true);
								CoursesInfo.dispose();
						

							} else {
								JOptionPane.showMessageDialog(null, "Please Insert Information");								
							}

						} catch (Exception ex) {							
							ex.printStackTrace();
						}

						
					} else {
						
						try {							
							String sql1 = "insert into courses_info values('" +rn +"','" + rn1 + "','" + rn2 + "','" + rn3+ "','" + rn4 + "',"
									+ "'" + rn5 + "','" + rn6 + "','" + rn7 + "','" + rn8 + "','" + rn9 + "')";
							int y = statement.executeUpdate(sql1);
							if (y == 1) {

								JOptionPane.showMessageDialog(null, "Information Inserted Succesfully");
										
								WorkExperienceInfo workExperienceInfo = new WorkExperienceInfo(uid);
								workExperienceInfo.WorkExInfo.setVisible(true);
								CoursesInfo.dispose();
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
		CoursesInfo.getContentPane().add(btnNext);
		
		JLabel lblCourseName = new JLabel("Course Name:");
		lblCourseName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourseName.setBounds(450, 120, 128, 25);
		CoursesInfo.getContentPane().add(lblCourseName);
		
		cc1 = new JTextField();
		cc1.setColumns(10);
		cc1.setBounds(611, 123, 160, 20);
		CoursesInfo.getContentPane().add(cc1);
		
		JLabel lblInstituteName = new JLabel("Institute Name:");
		lblInstituteName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInstituteName.setBounds(450, 152, 128, 25);
		CoursesInfo.getContentPane().add(lblInstituteName);
		
		ii1 = new JTextField();
		ii1.setColumns(10);
		ii1.setBounds(611, 155, 160, 17);
		CoursesInfo.getContentPane().add(ii1);
		
		yy1 = new JTextField();
		yy1.setColumns(10);
		yy1.setBounds(611, 177, 160, 17);
		CoursesInfo.getContentPane().add(yy1);
		
		JLabel lblCourseName_1 = new JLabel("Course Name:");
		lblCourseName_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourseName_1.setBounds(450, 223, 128, 25);
		CoursesInfo.getContentPane().add(lblCourseName_1);
		
		cc2 = new JTextField();
		cc2.setColumns(10);
		cc2.setBounds(611, 226, 160, 20);
		CoursesInfo.getContentPane().add(cc2);
		
		JLabel lblCollegeUnivercity_1 = new JLabel("Institute Name:");
		lblCollegeUnivercity_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCollegeUnivercity_1.setBounds(450, 255, 128, 25);
		CoursesInfo.getContentPane().add(lblCollegeUnivercity_1);
		
		ii2 = new JTextField();
		ii2.setColumns(10);
		ii2.setBounds(611, 258, 160, 17);
		CoursesInfo.getContentPane().add(ii2);
		
		JLabel lblCgpapercentage_1 = new JLabel("Year Of Course :");
		lblCgpapercentage_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCgpapercentage_1.setBounds(450, 277, 128, 25);
		CoursesInfo.getContentPane().add(lblCgpapercentage_1);
		
		yy2 = new JTextField();
		yy2.setColumns(10);
		yy2.setBounds(611, 280, 160, 17);
		CoursesInfo.getContentPane().add(yy2);
		
		cc3 = new JTextField();
		cc3.setColumns(10);
		cc3.setBounds(611, 326, 160, 20);
		CoursesInfo.getContentPane().add(cc3);
		
		JLabel lblCollegeUnivercity_1_1 = new JLabel("Institute Name:");
		lblCollegeUnivercity_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCollegeUnivercity_1_1.setBounds(450, 355, 128, 25);
		CoursesInfo.getContentPane().add(lblCollegeUnivercity_1_1);
		
		ii3 = new JTextField();
		ii3.setColumns(10);
		ii3.setBounds(611, 358, 160, 17);
		CoursesInfo.getContentPane().add(ii3);
		
		JLabel lblCgpapercentage_1_1 = new JLabel("Year Of Course :");
		lblCgpapercentage_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCgpapercentage_1_1.setBounds(450, 377, 128, 25);
		CoursesInfo.getContentPane().add(lblCgpapercentage_1_1);
		
		yy3 = new JTextField();
		yy3.setColumns(10);
		yy3.setBounds(611, 380, 160, 17);
		CoursesInfo.getContentPane().add(yy3);
		
		JLabel lblYearOfPassout_1_1_1 = new JLabel("Year Of Course :");
		lblYearOfPassout_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYearOfPassout_1_1_1.setBounds(450, 173, 128, 25);
		CoursesInfo.getContentPane().add(lblYearOfPassout_1_1_1);
		
		JLabel lblCourseName_1_1 = new JLabel("Course Name:");
		lblCourseName_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourseName_1_1.setBounds(450, 322, 128, 25);
		CoursesInfo.getContentPane().add(lblCourseName_1_1);
	}

}
