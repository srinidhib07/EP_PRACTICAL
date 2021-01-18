package com.klu.main;
import com.klu.Bean.StudentBean;
import com.klu.connections.DBUtil;
import com.klu.insert.DAO;
public class StudentMain {
	public static void main(String args[])
	{
		StudentBean sb = new StudentBean();
		sb.setRegNo(1900);
		sb.setName("Nidhi");
		sb.setEmail("sri@gmail.com");
		DAO dao = new DAO();
		try {
		int i=dao.StudentInsert(sb);
		
		if(i>0)
			System.out.println("Your insertion was successfull");
		else
			System.out.println("Insertion failed");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	

}
