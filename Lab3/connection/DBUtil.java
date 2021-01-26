package com.klu.connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class DBUtil {
	final static String forName="com.mysql.jdbc.Driver";
	final static String dbURL = "jdbc:mysql://localhost:3306/Lab3";
	final static String username = "root";
	final static String password = "root";
	public static Connection DBConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName(forName);
		Connection con = java.sql.DriverManager.getConnection(dbURL,username,password);
		return con;
	}

}
