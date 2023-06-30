package com.cglia.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDao {
	static String url = "jdbc:mysql://192.168.60.30:3306/siva_krishna?user=siva&password=siva@12345";
	private static Connection con;

	private ConnectionDao() {
	}

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // loading the Driver
			con = DriverManager.getConnection(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}

}
