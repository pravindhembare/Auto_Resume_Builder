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
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class WorkExperienceInfo {

	JFrame WorkExInfo;
	private JTextField us;
	private JTextField c1;
	private JTextField d1;
	private JTextField c2;
	private JTextField d2;
	private static JTextArea a1;
	private static JTextArea a2;

	String uid;
	Connection conn;
	PreparedStatement pst;
	Statement statement;
	ResultSet rs;


//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					WorkExperienceInfo window = new WorkExperienceInfo();
//					window.WorkExInfo.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	
//	public WorkExperienceInfo() {
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
	

	public WorkExperienceInfo(String uid) {
		initialize();
		Connect();
		this.us.setText(uid);

		try {
			String sql = "select * from work_exp_info where userid='" + us.getText() + "'";
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {

				String un1 = rs.getString("c1");
				String un2 = rs.getString("a1");
				String un3 = rs.getString("d1");
				String un4 = rs.getString("c2");
				String un5 = rs.getString("a2");
				String un6 = rs.getString("d2");

				this.c1.setText(un1);
					a1.setText(un2);
				this.d1.setText(un3);
				this.c2.setText(un4);
					a2.setText(un5);
				this.d2.setText(un6);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void initialize() {
		WorkExInfo = new JFrame();
		WorkExInfo.setBounds(100, 100, 850, 550);
		WorkExInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WorkExInfo.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 413, 522);
		WorkExInfo.getContentPane().add(panel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(WorkExperienceInfo.class.getResource("/images/laptop2.jpg")));
		lblNewLabel_2.setBounds(29, 118, 360, 148);
		panel.add(lblNewLabel_2);

		JButton btnback = new JButton("..Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoursesInfo coursesInfo = new CoursesInfo(uid);
				coursesInfo.CoursesInfo.setVisible(true);
				WorkExInfo.dispose();
			}
		});
		btnback.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnback.setBounds(423, 11, 70, 20);
		WorkExInfo.getContentPane().add(btnback);

		us = new JTextField();
		us.setColumns(10);
		us.setBounds(738, 11, 86, 20);
		WorkExInfo.getContentPane().add(us);

		JLabel lblPersonalInformation_1 = new JLabel("Work Experience");
		lblPersonalInformation_1.setForeground(Color.BLACK);
		lblPersonalInformation_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPersonalInformation_1.setBounds(530, 51, 200, 37);
		WorkExInfo.getContentPane().add(lblPersonalInformation_1);

		JButton btnNext = new JButton("Next..");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String rn1 = c1.getText();
				String rn2 = a1.getText();
				String rn3 = d1.getText();
				String rn4 = c2.getText();
				String rn5 = a2.getText();
				String rn6 = d2.getText();
				String rn = us.getText();

				try {
					String sql = "select * from work_exp_info where userid='" + us.getText() + "'";
					ResultSet rs = statement.executeQuery(sql);
					if (rs.next()) {
						uid = rs.getString("userid");
						try {
							String sql1 = "update work_exp_info set c1 = '" + rn1 + "', a1 = '" + rn2 + "', d1 = '"
									+ rn3 + "', c2 = '" + rn4 + "'" + ",a2 = '" + rn5 + "', d2 = '" + rn6
									+ "' where userid = '" + rn + "'";
							int y = statement.executeUpdate(sql1);
							if (y == 1) {

								JOptionPane.showMessageDialog(null, "Information Update Succesfully");
								ExtraCirricularActInfo actInfo = new ExtraCirricularActInfo(uid);
								actInfo.ExtraCirActInfo.setVisible(true);
								WorkExInfo.dispose();

							} else {
								JOptionPane.showMessageDialog(null, "Please Insert Information");
							}

						} catch (Exception ex) {
							ex.printStackTrace();
						}

					} else {

						try {
							String sql1 = "insert into work_exp_info values('" + rn + "','" + rn1 + "','" + rn2 + "','"
									+ rn3 + "','" + rn4 + "'," + "'" + rn5 + "','" + rn6 + "')";
							int y = statement.executeUpdate(sql1);
							if (y == 1) {

								JOptionPane.showMessageDialog(null, "Information Inserted Succesfully");

								ExtraCirricularActInfo actInfo = new ExtraCirricularActInfo(uid);
								actInfo.ExtraCirActInfo.setVisible(true);
								WorkExInfo.dispose();
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
		btnNext.setBounds(714, 433, 110, 30);
		WorkExInfo.getContentPane().add(btnNext);

		JLabel lblCompanyname = new JLabel("CompanyName:");
		lblCompanyname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompanyname.setBounds(450, 120, 128, 25);
		WorkExInfo.getContentPane().add(lblCompanyname);

		c1 = new JTextField();
		c1.setColumns(10);
		c1.setBounds(611, 123, 213, 20);
		WorkExInfo.getContentPane().add(c1);

		JLabel lblInstituteName = new JLabel("Address :");
		lblInstituteName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInstituteName.setBounds(450, 156, 128, 25);
		WorkExInfo.getContentPane().add(lblInstituteName);

		d1 = new JTextField();
		d1.setColumns(10);
		d1.setBounds(611, 212, 160, 17);
		WorkExInfo.getContentPane().add(d1);

		JLabel lblYearOfPassout_1_1_1 = new JLabel("Duration:");
		lblYearOfPassout_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYearOfPassout_1_1_1.setBounds(450, 208, 128, 25);
		WorkExInfo.getContentPane().add(lblYearOfPassout_1_1_1);

		JLabel lblCompanyname_1 = new JLabel("CompanyName:");
		lblCompanyname_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompanyname_1.setBounds(450, 272, 128, 25);
		WorkExInfo.getContentPane().add(lblCompanyname_1);

		c2 = new JTextField();
		c2.setColumns(10);
		c2.setBounds(611, 275, 213, 20);
		WorkExInfo.getContentPane().add(c2);

		JLabel lblInstituteName_1 = new JLabel("Address :");
		lblInstituteName_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInstituteName_1.setBounds(450, 308, 128, 25);
		WorkExInfo.getContentPane().add(lblInstituteName_1);

		d2 = new JTextField();
		d2.setColumns(10);
		d2.setBounds(611, 367, 160, 17);
		WorkExInfo.getContentPane().add(d2);

		JLabel lblYearOfPassout_1_1_1_1 = new JLabel("Duration:");
		lblYearOfPassout_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYearOfPassout_1_1_1_1.setBounds(450, 363, 128, 25);
		WorkExInfo.getContentPane().add(lblYearOfPassout_1_1_1_1);
		
		a1 = new JTextArea();
		a1.setWrapStyleWord(true);
		a1.setToolTipText("");
		a1.setBounds(611, 154, 213, 49);
		WorkExInfo.getContentPane().add(a1);
		
		a2 = new JTextArea();
		a2.setWrapStyleWord(true);
		a2.setToolTipText("");
		a2.setBounds(611, 306, 213, 49);
		WorkExInfo.getContentPane().add(a2);
	}
}
