package com.dypatil.autoresumebuilder.application;

import java.awt.EventQueue;

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

public class AcademicInfo {

	 JFrame AcademicInfo;
	private JTextField us;
	private JTextField ee1;
	private JTextField cc1;
	private JTextField pp1;
	private JTextField yy1;
	private JTextField ee2;
	private JTextField cc2;
	private JTextField pp2;
	private JTextField yy2;
	private JTextField ee3;
	private JTextField cc3;
	private JTextField pp3;
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
					AcademicInfo window = new AcademicInfo();
					window.AcademicInfo.setVisible(true);
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
	public AcademicInfo() {
		initialize();
	}
	
	public AcademicInfo(String uid) {
		initialize();
		Connect();
		this.us.setText(uid);
		
		try {						
			String sql = "select * from academic_info where userid='" + us.getText() + "'";
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {

				String un1 = rs.getString("e1");
				String un2 = rs.getString("c1");
				String un3 = rs.getString("p1");
				String un4 = rs.getString("y1");
				String un5 = rs.getString("e2");
				String un6 =rs.getString("c2");
				String un7 = rs.getString("p2");
				String un8 = rs.getString("y2");
				String un9 = rs.getString("e3");
				String un10 = rs.getString("c3");
				String un11 = rs.getString("p3");
				String un12 =rs.getString("y3");
				this.ee1.setText(un1);
				this.cc1.setText(un2);
				this.pp1.setText(un3);
				this.yy1.setText(un4);
				this.ee2.setText(un5);
				this.cc2.setText(un6);
				this.pp2.setText(un7);
				this.yy2.setText(un8);
				this.ee3.setText(un9);
				this.cc3.setText(un10);
				this.pp3.setText(un11);
				this.yy3.setText(un12);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}	

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AcademicInfo = new JFrame();
		AcademicInfo.getContentPane().setBackground(Color.WHITE);
		AcademicInfo.setBounds(100, 100, 850, 550);
		AcademicInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AcademicInfo.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 413, 522);
		AcademicInfo.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(AcademicInfo.class.getResource("/images/laptop3.jpg")));
		lblNewLabel_2.setBounds(29, 118, 360, 148);
		panel.add(lblNewLabel_2);
		
		JButton btnback = new JButton("..Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PersonalInfo personalInfo=new PersonalInfo();
				personalInfo.PersonalInfo.setVisible(true);
				AcademicInfo.dispose();
			}
		});
		btnback.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnback.setBounds(423, 11, 70, 20);
		AcademicInfo.getContentPane().add(btnback);
		
		us = new JTextField();
		us.setColumns(10);
		us.setBounds(738, 11, 86, 20);
		AcademicInfo.getContentPane().add(us);
		
		JLabel lblPersonalInformation_1 = new JLabel("Academic Information");
		lblPersonalInformation_1.setForeground(Color.BLACK);
		lblPersonalInformation_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPersonalInformation_1.setBounds(492, 38, 236, 37);
		AcademicInfo.getContentPane().add(lblPersonalInformation_1);
		
		JButton btnNext = new JButton("Next..");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rn1 = ee1.getText();
				String rn2 = cc1.getText();
				String rn3 = pp1.getText();
				String rn4 = yy1.getText();
				String rn5 = ee2.getText();
				String rn6 = cc2.getText();
				String rn7 = pp2.getText();
				String rn8 = yy2.getText();
				String rn9 = ee3.getText();
				String rn10 = cc3.getText();
				String rn11= pp3.getText();
				String rn12= yy3.getText();
				String rn = us.getText();
												


				try {					
					String sql = "select * from academic_info where userid='" + us.getText() + "'";
					ResultSet rs = statement.executeQuery(sql);
					if (rs.next()) {
						uid = rs.getString("userid");						
						try {													
							String sql1 = "update academic_info set e1 = '" + rn1 + "', c1 = '" + rn2 + "', p1 = '" + rn3+ "', y1 = '" + rn4 + "'"
																+ ",e2 = '" + rn5 + "', c2 = '" + rn6 + "', p2 = '" + rn7 + "', y2 = '" + rn8 + "' "
																+ ",e3 = '" + rn9 + "', c3= '" + rn10 + "', p3 = '" + rn11 + "', y3 = '" + rn12 + "' "
																+ "where userid = '" + rn + "'";
							int y = statement.executeUpdate(sql1);
							if (y == 1) {

								JOptionPane.showMessageDialog(null, "Information Update Succesfully");
								
								CoursesInfo coursesInfo = new CoursesInfo(uid);
								coursesInfo.CoursesInfo.setVisible(true);
								AcademicInfo.dispose();								

							} else {
								JOptionPane.showMessageDialog(null, "Please Insert Information");
							}

						} catch (Exception ex) {							
							ex.printStackTrace();
						}

						
					} else {
						
						try {							
							String sql1 = "insert into academic_info values('" +rn +"','" + rn1 + "','" + rn2 + "','" + rn3+ "','" + rn4 + "',"
									+ "'" + rn5 + "','" + rn6 + "','" + rn7 + "','" + rn8 + "','" + rn9 + "','" + rn10 + "','" + rn11+ "','" + rn12 + "')";
							int y = statement.executeUpdate(sql1);
							if (y == 1) {

								JOptionPane.showMessageDialog(null, "Information Inserted Succesfully");
										
								CoursesInfo coursesInfo = new CoursesInfo(uid);
								coursesInfo.CoursesInfo.setVisible(true);
								AcademicInfo.dispose();								

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
		AcademicInfo.getContentPane().add(btnNext);
		
		JLabel lblHigherEducation = new JLabel("Higher Education :");
		lblHigherEducation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHigherEducation.setBounds(439, 100, 128, 25);
		AcademicInfo.getContentPane().add(lblHigherEducation);
		
		ee1 = new JTextField();
		ee1.setColumns(10);
		ee1.setBounds(600, 103, 160, 20);
		AcademicInfo.getContentPane().add(ee1);
		
		JLabel lblCollegeUnivercity = new JLabel("College/Univercity :");
		lblCollegeUnivercity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCollegeUnivercity.setBounds(439, 132, 128, 25);
		AcademicInfo.getContentPane().add(lblCollegeUnivercity);
		
		cc1 = new JTextField();
		cc1.setColumns(10);
		cc1.setBounds(600, 135, 160, 17);
		AcademicInfo.getContentPane().add(cc1);
		
		JLabel lblCgpapercentage = new JLabel("CGPA/Percentage:");
		lblCgpapercentage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCgpapercentage.setBounds(439, 154, 128, 25);
		AcademicInfo.getContentPane().add(lblCgpapercentage);
		
		JLabel lblYearOfPassout = new JLabel("Year Of Passout :");
		lblYearOfPassout.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYearOfPassout.setBounds(439, 175, 128, 25);
		AcademicInfo.getContentPane().add(lblYearOfPassout);
		
		pp1 = new JTextField();
		pp1.setColumns(10);
		pp1.setBounds(600, 157, 160, 17);
		AcademicInfo.getContentPane().add(pp1);
		
		yy1 = new JTextField();
		yy1.setColumns(10);
		yy1.setBounds(600, 178, 160, 17);
		AcademicInfo.getContentPane().add(yy1);
		
		JLabel lblHscdiploma = new JLabel("HSC/Diploma:");
		lblHscdiploma.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHscdiploma.setBounds(439, 220, 128, 25);
		AcademicInfo.getContentPane().add(lblHscdiploma);
		
		ee2 = new JTextField();
		ee2.setColumns(10);
		ee2.setBounds(600, 223, 160, 20);
		AcademicInfo.getContentPane().add(ee2);
		
		JLabel lblCollegeUnivercity_1 = new JLabel("College/Univercity :");
		lblCollegeUnivercity_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCollegeUnivercity_1.setBounds(439, 252, 128, 25);
		AcademicInfo.getContentPane().add(lblCollegeUnivercity_1);
		
		cc2 = new JTextField();
		cc2.setColumns(10);
		cc2.setBounds(600, 255, 160, 17);
		AcademicInfo.getContentPane().add(cc2);
		
		JLabel lblCgpapercentage_1 = new JLabel("CGPA/Percentage:");
		lblCgpapercentage_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCgpapercentage_1.setBounds(439, 274, 128, 25);
		AcademicInfo.getContentPane().add(lblCgpapercentage_1);
		
		JLabel lblYearOfPassout_1 = new JLabel("Year Of Passout :");
		lblYearOfPassout_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYearOfPassout_1.setBounds(439, 295, 128, 25);
		AcademicInfo.getContentPane().add(lblYearOfPassout_1);
		
		pp2 = new JTextField();
		pp2.setColumns(10);
		pp2.setBounds(600, 277, 160, 17);
		AcademicInfo.getContentPane().add(pp2);
		
		yy2 = new JTextField();
		yy2.setColumns(10);
		yy2.setBounds(600, 298, 160, 17);
		AcademicInfo.getContentPane().add(yy2);
		
		JLabel lblHigherEducation_1_1 = new JLabel("SSC :");
		lblHigherEducation_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHigherEducation_1_1.setBounds(449, 335, 79, 25);
		AcademicInfo.getContentPane().add(lblHigherEducation_1_1);
		
		ee3 = new JTextField();
		ee3.setColumns(10);
		ee3.setBounds(600, 339, 160, 20);
		AcademicInfo.getContentPane().add(ee3);
		
		JLabel lblCollegeUnivercity_1_1 = new JLabel("School/Univercity :");
		lblCollegeUnivercity_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCollegeUnivercity_1_1.setBounds(439, 368, 128, 25);
		AcademicInfo.getContentPane().add(lblCollegeUnivercity_1_1);
		
		cc3 = new JTextField();
		cc3.setColumns(10);
		cc3.setBounds(600, 371, 160, 17);
		AcademicInfo.getContentPane().add(cc3);
		
		JLabel lblCgpapercentage_1_1 = new JLabel("CGPA/Percentage:");
		lblCgpapercentage_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCgpapercentage_1_1.setBounds(439, 390, 128, 25);
		AcademicInfo.getContentPane().add(lblCgpapercentage_1_1);
		
		JLabel lblYearOfPassout_1_1 = new JLabel("Year Of Passout :");
		lblYearOfPassout_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYearOfPassout_1_1.setBounds(439, 411, 128, 25);
		AcademicInfo.getContentPane().add(lblYearOfPassout_1_1);
		
		pp3 = new JTextField();
		pp3.setColumns(10);
		pp3.setBounds(600, 393, 160, 17);
		AcademicInfo.getContentPane().add(pp3);
		
		yy3 = new JTextField();
		yy3.setColumns(10);
		yy3.setBounds(600, 414, 160, 17);
		AcademicInfo.getContentPane().add(yy3);
	}
}
