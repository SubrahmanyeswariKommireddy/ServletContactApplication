package com.appl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutPage extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {
		PrintWriter write=response.getWriter();
		HttpSession session=request.getSession(false);
		response.setContentType("text/html");
		write.print("LoggedOut");
		if(session!=null) {
		session.invalidate();
		}
		RequestDispatcher rd=request.getRequestDispatcher("/index.html");
		rd.include(request, response);
		
	}
	
}
