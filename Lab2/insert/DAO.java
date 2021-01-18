package com.klu.insert;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import com.klu.Bean.StudentBean;
import com.klu.connections.DBUtil;

public class DAO {
	public int StudentInsert(StudentBean student) throws ClassNotFoundException, SQLException
	{
		
		Connection con = DBUtil.DBConnection();
		
			PreparedStatement ps = con.prepareStatement("Insert into StudentBean values(1901,'ABC','a@b.c')");
			ps.setInt(1,student.getRegNo()); 
			ps.setString(2,student.getName());  
			ps.setString(3,student.getEmail());
			  
			int i=ps.executeUpdate();  
			System.out.println(i+" records inserted");  
			return i;
			
		
		
		
		
		
	}

}
