package com.dypatil.autoresumebuilder.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Properties {
	
	
//	registration
	private static String firstName;
	private static String lastName;
	private static String email;
	private static String phoneNo;
	
	public static String getFirstName() {
		return firstName;
	}	
	public static String getLastName() {
		return lastName;
	}	
	public static String getEmail() {
		return email;
	}	
	public static String getPhoneNo() {
		return phoneNo;
	}	
	
	
//	personal_info	
//	private static String image;
	private static String gender;
	private static String address2;
	private static String pincode;
	private static String nationality;
	private static String dob;
	private static String maritialstatus;
	
	public static String getGender() {
		return gender;
	}	
	public static String getAddress2() {
		return address2;
	}	
	public static String getPincode() {
		return pincode;
	}	
	public static String getNationality() {
		return nationality;
	}	
	public static String getDob() {
		return dob;
	}	
	public static String getMaritialstatus() {
		return maritialstatus;
	}	
	
	
//	academic_info
	private static String e1;
	private static String c1;
	private static String p1;
	private static String y1;
	private static String e2;
	private static String c2;
	private static String p2;
	private static String y2;
	
	public static String getE1() {
		return e1;
	}	
	public static String getC1() {
		return c1;
	}	
	public static String getP1() {
		return p1;
	}	
	public static String getY1() {
		return y1;
	}	
	public static String getE2() {
		return e2;
	}	
	public static String getC2() {
		return c2;
	}	
	public static String getP2() {
		return p2;
	}	
	public static String getY2() {
		return y2;
	}	
	
	
//	courses_info
	private static String cc1;  //c1
	private static String i1;
	private static String yy1;  //y1
	private static String cc2;  //c2
	private static String i2;
	private static String yy2;  //y2
	private static String c3;
	private static String i3;
	private static String y3;
	
	public static String getCc1() {
		return cc1;
	}	
	public static String getI1() {
		return i1;
	}	
	public static String getYy1() {
		return yy1;
	}	
	public static String getCc2() {
		return cc2;
	}	
	public static String getI2() {
		return i2;
	}
	public static String getYy2() {
		return yy2;
	}
	public static String getC3() {
		return c3;
	}
	public static String getI3() {
		return i3;
	}
	public static String getY3() {
		return y3;
	}
	
	
//	work_exp_info
	private static String ccc1;  //c1
	private static String a1;
	private static String d1;
	private static String ccc2;  //c2
	private static String a2;
	private static String d2;
	
	public static String getCcc1() {
		return ccc1;
	}
	public static String getA1() {
		return a1;
	}
	public static String getD1() {
		return d1;
	}
	public static String getCcc2() {
		return ccc2;
	}
	public static String getA2() {
		return a2;
	}
	public static String getD2() {
		return d2;
	}
	

//	extra_cirru_act_info
	private static String aa1;	//a1
	private static String dd1;	//d1	
	private static String aa2;	//a2	
	private static String dd2;	//d2
	private static String a3;
	private static String d3;
	
	public static String getAa1() {
		return aa1;
	}	
	public static String getDd1() {
		return dd1;
	}	
	public static String getAa2() {
		return aa2;
	}	
	public static String getDd2() {
		return dd2;
	}	
	public static String getA3() {
		return a3;
	}	
	public static String getD3() {
		return d3;
	}
	

//	project_info
	private static String name1;
	private static String duration1;
	private static String description1;
	private static String name2;
	private static String duration2;
	private static String description2;
	
	public static String getName1() {
		return name1;
	}
	public static String getDuration1() {
		return duration1;
	}
	public static String getDescription1() {
		return description1;
	}
	public static String getName2() {
		return name2;
	}
	public static String getDuration2() {
		return duration2;
	}
	public static String getDescription2() {
		return description2;
	}
	

//	hobbies_info
	private static String hb1;
	private static String hb2;
	private static String hb3;
	private static String hb4;
	
	public static String getHb1() {
		return hb1;
	}
	public static String getHb2() {
		return hb2;
	}	
	public static String getHb3() {
		return hb3;
	}
	public static String getHb4() {
		return hb4;
	}
	
//	skill_info
	private static String sk1;
	private static String sk2;
	private static String sk3;
	private static String sk4;
	
	public static String getSk1() {
		return sk1;
	}
	public static String getSk2() {
		return sk2;
	}
	public static String getSk3() {
		return sk3;
	}
	public static String getSk4() {
		return sk4;
	}
	
	
//	abo_dec_into
	private static String about;
	private static String declaration;
		
	public static String getAbout() {
		return about;
	}
	public static String getDeclaration() {
		return declaration;
	}
	

	
	
	private static String userid;
	public static String getUserid() {
		return userid;
	}
	public static void setUserid(String userid) {
		Properties.userid = userid;
	}
	
	public Properties() {
		
	}
	
	public Properties(String uid, String fname) {
		getProperty(uid);
		new Templet1(fname);
	}
	
	
	Connection conn;
	PreparedStatement pst;
	Statement statement;
	ResultSet rs;
				
	private void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/resumebuilder", "root", "root");
			statement = conn.createStatement();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void getProperty(String uid) {
		connect();
		setUserid(uid);
						
		String sql1 = "select * from registration where username='" + userid+"'";
		ResultSet rs1;
		String sql2 = "select * from personal_info where userid='" + userid+"'";
		ResultSet rs2;
		String sql3 = "select * from academic_info where userid='" + userid+"'";
		ResultSet rs3;
		String sql4 = "select * from courses_info where userid='" + userid+"'";
		ResultSet rs4;
		String sql5 = "select * from work_exp_info where userid='" + userid+"'";
		ResultSet rs5;
		String sql6 = "select * from extra_cirru_act_info where userid='" + userid+"'";
		ResultSet rs6;
		String sql7 = "select * from project_info where userid='" + userid+"'";
		ResultSet rs7;
		String sql8 = "select * from hobbies_info where userid='" + userid+"'";
		ResultSet rs8;
		String sql9 = "select * from skill_info where userid='" + userid+"'";
		ResultSet rs9;
		String sql10 = "select * from abo_dec_into where userid='" + userid+"'";
		ResultSet rs10;
		try {
			rs1 = statement.executeQuery(sql1);
			if (rs1.next()) {
				firstName = rs1.getString("firstName");
				lastName = rs1.getString("lastName");
				email = rs1.getString("email");
				phoneNo = rs1.getString("phoneNo");
			}
			
			rs2 = statement.executeQuery(sql2);
			if (rs2.next()) {
				gender = rs2.getString("gender");
				address2 = rs2.getString("address2");
				pincode = rs2.getString("pincode");
				nationality = rs2.getString("nationality");
				dob = rs2.getString("dob");
				maritialstatus = rs2.getString("maritialstatus");
			}
			
			rs3 = statement.executeQuery(sql3);
			if (rs3.next()) {
				e1 = rs3.getString("e1");
				c1 = rs3.getString("c1");
				p1 = rs3.getString("p1");
				y1 = rs3.getString("y1");
				e2 = rs3.getString("e2");
				c2 = rs3.getString("c2");
				p2 = rs3.getString("p2");
				y2 = rs3.getString("y2");
			}
			
			rs4 = statement.executeQuery(sql4);
			if (rs4.next()) {
				cc1 = rs4.getString("c1");
				i1 = rs4.getString("i1");
				yy1 = rs4.getString("y1");
				cc2 = rs4.getString("c2");
				i2 = rs4.getString("i2");
				yy2 = rs4.getString("y2");
				c3 = rs4.getString("c3");
				i3 = rs4.getString("i3");
				y3 = rs4.getString("y3");
			}
			
			rs5 = statement.executeQuery(sql5);
			if (rs5.next()) {
				ccc1 = rs5.getString("c1");
				a1 = rs5.getString("a1");
				d1 = rs5.getString("d1");
				a2 = rs5.getString("a2");
				d2 = rs5.getString("d2");
			}
			
			rs6 = statement.executeQuery(sql6);
			if (rs6.next()) {
				aa1 = rs6.getString("a1");
				dd1 = rs6.getString("d1");
				aa2 = rs6.getString("a2");
				dd2 = rs6.getString("d2");
				a3 = rs6.getString("a3");
				d3 = rs6.getString("d3");
			}
			
			rs7 = statement.executeQuery(sql7);
			if (rs7.next()) {
				name1 = rs7.getString("name1");
				duration1 = rs7.getString("duration1");
				description1 = rs7.getString("description1");
				name2 = rs7.getString("name2");
				duration2 = rs7.getString("duration2");
				description2 = rs7.getString("description2");				
			}
			
			rs8 = statement.executeQuery(sql8);
			if (rs8.next()) {
				hb1 = rs8.getString("hb1");
				hb2 = rs8.getString("hb2");
				hb3 = rs8.getString("hb3");
				hb4 = rs8.getString("hb4");
			}
			
			rs9 = statement.executeQuery(sql9);
			if (rs9.next()) {
				sk1 = rs9.getString("sk1");
				sk2 = rs9.getString("sk2");
				sk3 = rs9.getString("sk3");
				sk4 = rs9.getString("sk4");
			}
			
			rs10 = statement.executeQuery(sql10);
			if (rs10.next()) {
				about = rs10.getString("about");
				declaration = rs10.getString("declaration");
				
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

	public void printProperty() {
		
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(phoneNo);
		
		System.out.println();
		
		System.out.println(gender);
		System.out.println(address2);
		System.out.println(pincode);
		System.out.println(nationality);
		System.out.println(dob);
		System.out.println(maritialstatus);
		
		System.out.println();
		
		System.out.println(e1);
		System.out.println(c1);
		System.out.println(p1);
		System.out.println(y1);
		System.out.println(e2);
		System.out.println(c2);
		System.out.println(p2);
		System.out.println(y2);
		
		System.out.println();
		
		System.out.println(cc1);
		System.out.println(i1);
		System.out.println(yy1);
		System.out.println(cc2);
		System.out.println(i2);
		System.out.println(yy2);
		System.out.println(c3);
		System.out.println(i3);
		System.out.println(y3);
		
		System.out.println();
		
		System.out.println(ccc1);
		System.out.println(a1);
		System.out.println(d1);
		System.out.println(ccc2);
		System.out.println(a2);
		System.out.println(d2);
		
		System.out.println();
		
		System.out.println(aa1);
		System.out.println(dd1);
		System.out.println(aa2);
		System.out.println(dd2);
		System.out.println(a3);
		System.out.println(d3);

		System.out.println();
		
		System.out.println(name1);
		System.out.println(duration1);
		System.out.println(description1);
		System.out.println(name2);
		System.out.println(duration2);
		System.out.println(description2);

		System.out.println();
		
		System.out.println(hb1);
		System.out.println(hb2);
		System.out.println(hb3);
		System.out.println(hb4);

		System.out.println();
		
		System.out.println(sk1);
		System.out.println(sk2);
		System.out.println(sk3);
		System.out.println(sk4);

		System.out.println();
		
		System.out.println(about);
		System.out.println(declaration);
		
	}
	

}
