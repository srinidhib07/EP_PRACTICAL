package com.klu.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import com.klu.Bean.SalesBean;
import com.klu.connection.DBUtil;
import java.sql.ResultSet;
public class DAO {
	public void insertItem(SalesBean sales) throws SQLException, ClassNotFoundException
	{
		Connection con = DBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("Insert into Sales values(?,?,?)");
		ps.setInt(1,sales.getItemID());
		ps.setString(2, sales.getItemName());
		ps.setDouble(3, sales.getCost());
		
		int i=ps.executeUpdate();
		if(i>0)
		{
			System.out.println(i+" record inserted");
		}
		else
			System.out.println("Insertion failed");
		
	}
	public void displayBill(SalesBean sales, int itemId) throws SQLException, ClassNotFoundException
	{
		Connection con =DBUtil.DBConnection();
		
		PreparedStatement ps= con.prepareStatement("select sum(cost) from Sales");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getDouble(1));
		}
		
	}
	public void displayDetails(SalesBean sales) throws SQLException, ClassNotFoundException
	{
		Connection con = DBUtil.DBConnection();
		PreparedStatement ps = con.prepareStatement("Select * from Sales");
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
		}
	}
	
	

}
