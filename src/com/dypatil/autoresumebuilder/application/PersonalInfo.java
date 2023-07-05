package com.dypatil.autoresumebuilder.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.sql.*;

public class PersonalInfo {

	JFrame PersonalInfo;
	private JTextField fname;
	private JTextField lname;
	private JTextField phoneno;
	private JTextField email;
	private JTextField address1;
	private JTextField address2;
	private JTextField pincode;
	private JTextField nationality;
	private JTextField dob;
	private JTextField us;
	static String uid;
	
	Connection conn;
	PreparedStatement pst;
	Statement statement;
	ResultSet rs;
	private JTextField imagePath;
	private JTextField ms;

	File f = null;
	String path = null;
	int s = 0;
	byte[] pimage = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalInfo window = new PersonalInfo();
					window.PersonalInfo.setVisible(true);
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
	
	public PersonalInfo() {
		initialize();
	}

	public PersonalInfo(String uid) {
		initialize();
		Connect();
		
		this.us.setText(uid);

		try {			
			String sql = "select * from registration where username='" + us.getText() + "'";
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {

				String un1 = rs.getString("firstName");
				String un2 = rs.getString("lastName");
				String un3 = rs.getString("email");
				String un4 = rs.getString("phoneNo");
				this.fname.setText(un1);
				this.lname.setText(un2);
				this.email.setText(un3);
				this.phoneno.setText(un4);
			} else {
				JOptionPane.showMessageDialog(null, "Not Fetching Your Data");
			}			
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {						
			String sql = "select * from personal_info where userid='" + us.getText() + "'";
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {

				String un5 = rs.getString("gender");
				String un6 = rs.getString("address2");
				String un7 = rs.getString("pincode");
				String un8 = rs.getString("nationality");
				String un9 = rs.getString("dob");
				String un10 =rs.getString("maritialstatus");
				this.address1.setText(un5);
				this.address2.setText(un6);
				this.pincode.setText(un7);
				this.nationality.setText(un8);
				this.dob.setText(un9);
				this.ms.setText(un10);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}



	
	private void initialize() {
		PersonalInfo = new JFrame();
		PersonalInfo.setBounds(100, 100, 850, 550);
		PersonalInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		PersonalInfo.getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("First Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(471, 90, 105, 25);
		panel.add(lblNewLabel);

		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(621, 94, 160, 20);
		panel.add(fname);

		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastName.setBounds(471, 126, 105, 25);
		panel.add(lblLastName);

		JLabel lblNewLabel_1_1 = new JLabel("Gender :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(471, 268, 105, 25);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Address :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(471, 304, 105, 25);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Pincode :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(471, 340, 105, 25);
		panel.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Nationality :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(471, 376, 105, 25);
		panel.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("DOB :");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(471, 412, 105, 25);
		panel.add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Phone no. :");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(471, 162, 105, 25);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Email :");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(471, 196, 105, 25);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1);

		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(621, 130, 160, 20);
		panel.add(lname);

		phoneno = new JTextField();
		phoneno.setColumns(10);
		phoneno.setBounds(621, 167, 160, 20);
		panel.add(phoneno);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(621, 200, 160, 20);
		panel.add(email);

		address1 = new JTextField();
		address1.setColumns(10);
		address1.setBounds(621, 272, 160, 20);
		panel.add(address1);

		address2 = new JTextField();
		address2.setColumns(10);
		address2.setBounds(621, 308, 160, 20);
		panel.add(address2);

		pincode = new JTextField();
		pincode.setColumns(10);
		pincode.setBounds(621, 344, 160, 20);
		panel.add(pincode);

		nationality = new JTextField();
		nationality.setColumns(10);
		nationality.setBounds(621, 380, 160, 20);
		panel.add(nationality);

		JLabel lblPersonalInformation_1 = new JLabel("Personal Information");
		lblPersonalInformation_1.setForeground(Color.BLACK);
		lblPersonalInformation_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPersonalInformation_1.setBounds(557, 30, 223, 37);
		panel.add(lblPersonalInformation_1);

		JButton btnNext = new JButton("Next..");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rn1 = fname.getText();
				String rn2 = lname.getText();
				String rn3 = email.getText();
				String rn4 = phoneno.getText();
				String rn5 = us.getText();
				
				
				try {										
					String sql1 = "update registration set firstName = '" + rn1 + "', lastName = '" + rn2 + "', email = '" + rn3+ "', phoneNo = '" + rn4 + "'  where username = '" + rn5 + "'";
					statement.executeUpdate(sql1);
					
				} catch (Exception ex) {
					ex.printStackTrace();

				}


				try {					
					String sql = "select * from personal_info where userid='" + us.getText() + "'";
					ResultSet rs = statement.executeQuery(sql);
					if (rs.next()) {
						uid = rs.getString("userid");
						File f = new File(path);
						String uus = us.getText();
						InputStream is = new FileInputStream(f);
						String aaddress1 = address1.getText();
						String aaddress2 = address2.getText();
						String ppincode = pincode.getText();
						String nnationality = nationality.getText();
						String ddob = dob.getText();
						String mms = ms.getText();
						try {													
							String sql1 = "update personal_info set image = '" + is + "', gender = '" + aaddress1 + "', address2 = '" + aaddress2 + "', pincode = '" + ppincode + "', nationality = '" + nnationality + "', dob = '" + ddob + "', maritialstatus = '" + mms + "' where userid = '" + uus + "'";
							int y = statement.executeUpdate(sql1);
							if (y == 1) {

								JOptionPane.showMessageDialog(null, "Information Update Succesfully");
								
								
								AcademicInfo academicInfo = new AcademicInfo(uid);								
								academicInfo .AcademicInfo.setVisible(true);
								PersonalInfo.dispose();

							} else {
								JOptionPane.showMessageDialog(null, "Please Insert Information");
							}

						} catch (Exception ex) {							
							ex.printStackTrace();
						}

						is.close();
					} else {
						File f = new File(path);
						String uus = us.getText();
						InputStream is = new FileInputStream(f);
						String aaddress1 = address1.getText();
						String aaddress2 = address2.getText();
						String ppincode = pincode.getText();
						String nnationality = nationality.getText();
						String ddob = dob.getText();
						String mms = ms.getText();
						try {							
							String sql1 = "insert into personal_info values('" + uus + "','" + is + "','" + aaddress1
									+ "','" + aaddress2 + "','" + ppincode + "','" + nnationality + "','" + ddob + "','" + mms+ "')";
							int y = statement.executeUpdate(sql1);
							if (y == 1) {

								JOptionPane.showMessageDialog(null, "Information Inserted Succesfully");
																
								AcademicInfo academicInfo = new AcademicInfo(uid);								
								academicInfo .AcademicInfo.setVisible(true);
								PersonalInfo.dispose();

							} else {
								JOptionPane.showMessageDialog(null, "Please Insert Correct Information");
							}

						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Please Insert Correct Information");
						}
						is.close();
					}					

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNext.setBounds(718, 480, 110, 30);
		panel.add(btnNext);

		JButton btnback = new JButton("..Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInPage logInPage = new LogInPage();
				logInPage.LogInPage.setVisible(true);
				PersonalInfo.dispose();
			}
		});
		btnback.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnback.setBounds(453, 11, 70, 20);
		panel.add(btnback);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("Profile Picture :");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(471, 232, 105, 25);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1_1);

		dob = new JTextField();
		dob.setColumns(10);
		dob.setBounds(621, 416, 160, 20);
		panel.add(dob);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 413, 533);
		panel.add(panel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(PersonalInfo.class.getResource("/images/ok laptop1.png")));
		lblNewLabel_2.setBounds(53, 107, 360, 148);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Auto Resume Builder");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(281, 49, 223, 37);
		panel_1.add(lblNewLabel_1);

		JLabel labelImage = new JLabel("");
		labelImage.setBounds(69, 294, 214, 135);
		panel_1.add(labelImage);

		us = new JTextField();
		us.setBounds(725, 8, 86, 20);
		panel.add(us);
		us.setColumns(10);

		JButton btnBrowse = new JButton("Browse..");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
				fileChooser.addChoosableFileFilter(fnwf);
				int load = fileChooser.showOpenDialog(null);

				if (load == JFileChooser.APPROVE_OPTION) {
					f = fileChooser.getSelectedFile();

					path = f.getAbsolutePath();
					imagePath.setText(path);
					ImageIcon ii = new ImageIcon(path);
					Image img = ii.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
					labelImage.setIcon(new ImageIcon(img));

				}
			}
		});
		btnBrowse.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnBrowse.setBounds(621, 241, 70, 20);
		panel.add(btnBrowse);

		imagePath = new JTextField();
		imagePath.setColumns(10);
		imagePath.setBounds(695, 241, 86, 20);
		panel.add(imagePath);
		
		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("Marital Status :");
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(471, 446, 105, 25);
		panel.add(lblNewLabel_1_1_1_1_1_1_2);
		
		ms = new JTextField();
		ms.setColumns(10);
		ms.setBounds(618, 454, 160, 20);
		panel.add(ms);

	}
}
