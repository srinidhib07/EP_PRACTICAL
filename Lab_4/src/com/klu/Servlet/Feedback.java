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

import com.klu.Bean.FeedbackBean;
import com.klu.Bean.RegisterBean;
import com.klu.DAO.DAO;

/**
 * Servlet implementation class Feedback
 */
@WebServlet("/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feedback() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	int id=Integer.parseInt(request.getParameter("id"));
	    String feedback=request.getParameter("feedback");
	    FeedbackBean fb=new FeedbackBean();
	    fb.setId(id);
	   fb.setFeedback(feedback);
	   DAO dao=new DAO();
	   try {
		   int i=dao.enterFeedback(fb);
		   if(i>0)
	       {RequestDispatcher rd=request.getRequestDispatcher("display_f");
           request.setAttribute("feedbackbean",fb);
           rd.forward(request, response);
	       }
	       else {
	    	   PrintWriter pw=response.getWriter();
	    	   pw.print("Failed");
	       }
	   }
	   catch(ClassNotFoundException e)
	   {
		   e.printStackTrace();
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
	 
    	
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
