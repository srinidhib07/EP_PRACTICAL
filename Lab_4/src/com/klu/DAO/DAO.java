package com.klu.DAO;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.klu.Bean.FeedbackBean;
import com.klu.Bean.LoginBean;
import com.klu.Bean.RegisterBean;
import com.klu.Connections.DBUtil;
public class DAO {
           public int registerUser(RegisterBean rb) throws ClassNotFoundException ,SQLException{
             Connection con=DBUtil.DBConnection();
             String sql="insert into RegisterBean values(?,?,?,?,?,?)";
             PreparedStatement ps=con.prepareStatement(sql);
             	ps.setInt(1, rb.getId());
               ps.setString(2, rb.getFirstName());
               ps.setString(3, rb.getLastName());
               ps.setString(4,rb.getEmail());
               ps.setLong(5, rb.getPh());
               ps.setString(6, rb.getPassword());
               int i=ps.executeUpdate();
               return i;//insert rows
           }
           public int enterFeedback(FeedbackBean fb) throws ClassNotFoundException, SQLException
           {
        	   Connection con= DBUtil.DBConnection();
        	   String sql="insert into Feedback values(?,?)";
        	   PreparedStatement ps=con.prepareStatement(sql);
        	   ps.setInt(1, fb.getId());
        	   ps.setString(2,fb.getFeedback());
        	   int i=ps.executeUpdate();
        	   return i;
           }
           public boolean loginUser(String username, String password) throws ClassNotFoundException, SQLException
           {
        	   Connection con=DBUtil.DBConnection();
        	   String sql="select * from RegisterBean where email = ? and password = ?";
        	   PreparedStatement ps=con.prepareStatement(sql);
        	   ps.setString(1, username);
        	   ps.setString(2, password);
        	   ResultSet rs=ps.executeQuery();
        	   boolean res=rs.next();
        	   return res;
           }
           
}