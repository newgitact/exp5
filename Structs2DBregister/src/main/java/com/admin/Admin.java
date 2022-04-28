package com.admin;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import com.action.RegisterAction;
public class Admin {
	public static Connection conn() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
	}

	public static int register(RegisterAction ra) {
		int flag = 0;
		try {
			PreparedStatement ps = conn().prepareStatement("INSERT INTO struts2db VALUES(?,?,?,?)");
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
                        