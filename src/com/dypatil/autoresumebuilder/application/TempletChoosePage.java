package com.dypatil.autoresumebuilder.application;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import com.dypatil.autoresumebuilder.classes.Properties;

public class TempletChoosePage {

	 JFrame Temp;
	 
	 private static String userid;
		Connection conn;
		PreparedStatement pst;
		Statement statement;
		private JTextField us;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TempletChoosePage window = new TempletChoosePage();
//					window.Temp.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	public TempletChoosePage() {
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

	public TempletChoosePage(String uid) {
		initialize();
		Connect();
		userid = uid;
	this.us.setText(uid);
	}
	private void initialize() {
		Temp = new JFrame();
		Temp.setBounds(100, 100, 850, 550);
		Temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Temp.getContentPane().setLayout(null);
		
		JButton btnback = new JButton("..Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AboutAndDeclaInto aboutAndDeclaInto = new AboutAndDeclaInto(userid);
				aboutAndDeclaInto.AD.setVisible(true);
				Temp.dispose();
			}
		});
		btnback.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		btnback.setBounds(10, 11, 70, 20);
		Temp.getContentPane().add(btnback);
		
		JButton btnChoose = new JButton("Choose");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = JOptionPane.showInputDialog("Enter File Name");
				new Properties(userid,fname);
				Temp.dispose();
			}
		});
		btnChoose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnChoose.setBounds(142, 215, 110, 30);
		Temp.getContentPane().add(btnChoose);
		
		us = new JTextField();
		us.setText("<dynamic>");
		us.setColumns(10);
		us.setBounds(724, 8, 86, 20);
		Temp.getContentPane().add(us);
	}

}
