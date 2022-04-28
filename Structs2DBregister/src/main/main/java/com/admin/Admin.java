package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.action.RegisterAction;

public class Admin {
	public static Connection conn() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "Unmesh", "Unmesh@2001");
	}

	public static int register(RegisterAction ra) {
		int flag = 0;
		try {
			PreparedStatement ps = conn().prepareStatement("INSERT INTO STRUTS2DB VALUES(?,?,?,?)");
			ps.setInt(1, ra.getId());
			ps.setString(2, ra.getName());
			ps.setString(3, ra.getEmail());
			ps.setString(4, ra.getCity());
			flag = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
