package com.klu.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.klu.Bean.RegisterBean;
import com.klu.DAO.DAO;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Registration() {
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String fname=request.getParameter("fname");
	    String lname=request.getParameter("lname");
	    String email=request.getParameter("email");
	    long pno=Long.parseLong(request.getParameter("pno"));
	    String pw=request.getParameter("password");
	    RegisterBean rb=new RegisterBean();
	    rb.setId(id);
	   rb.setFirstName(fname);
	   rb.setLastName(lname);
	   rb.setEmail(email);
	   rb.setPh(pno);
	   rb.setPassword(pw);
	    //PrintWriter pw=response.getWriter();//response from servlet to client.
	    //pw.print(regno+" "+name);
	    DAO dao=new DAO();
	    try {
	       int i=dao.registerUser(rb);
	       if(i>0)
	       {
	    	   RequestDispatcher rd=request.getRequestDispatcher("display");
	           request.setAttribute("registerbean",rb);
	           rd.forward(request, response);
	       }
	       else {
	    	   RequestDispatcher rd=request.getRequestDispatcher("error.html");
	           
	           rd.include(request, response);
	       }
	    }
	    catch(ClassNotFoundException e)
	    {
	      e.printStackTrace();
	    }
	    catch(SQLException e) {
	      e.printStackTrace();
	    }
	}

}
