package com.klu.connections;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
	final static String forNameURL = "com.mysql.jdbc.Driver";
	final static String dbURL = "jdbc:mysql://localhost:3306/ep";
	final static String username = "root";
	final static String password = "root";
	public static Connection DBConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName(forNameURL);
		Connection con = java.sql.DriverManager.getConnection(dbURL,username,password);
		return con;
	}
	

}
