package com.klu.main;
import java.sql.SQLException;
import java.util.Scanner;
import com.klu.Bean.SalesBean;
import com.klu.DAO.DAO;

public class Main {
	public static void main(String args[])
	{
		SalesBean sb=new SalesBean();
		DAO dao=new DAO();
		Scanner s= new Scanner(System.in);
		while(true)
		{
			System.out.println("1. Insert item");
			System.out.println("2. Display total cost");
			System.out.println("3. Display details");
			System.out.println("4. Exit");
			System.out.println("Enter choice");
			int ch=s.nextInt();
			if(ch==1)
			{
				System.out.println("Enter item id: ");
				int id=s.nextInt();
				System.out.println("Enter item name: ");
				String name=s.next();
				System.out.println("Enter item cost: ");
				double cost=s.nextDouble();
				sb.setItemID(id);
				sb.setItemName(name);
				sb.setCost(cost);
				
				try {
					dao.insertItem(sb);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(ch==2)
			{
				try {
					System.out.println("Enter item id: ");
					int item_id=s.nextInt();
					dao.displayBill(sb, item_id);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if(ch==3)
			{
				try {
					dao.displayDetails(sb);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(ch==4)
			{
				break;
			}
			
		}
		
		
//		
		
		
		
	}

}
