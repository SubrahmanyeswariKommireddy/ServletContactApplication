package com.appl;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddContact extends HttpServlet{
   
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {

		ServletContext write=getServletContext();
//		write.getAttribute("email");
		String name=request.getParameter("name");
		String Email=request.getParameter("email");
		
		String PhoneNumber=request.getParameter("phone");
		String Address=request.getParameter("address");
		ContactList contact=new ContactList(name,PhoneNumber,Email, Address);
		
		write.setAttribute(Email,contact);
		request.getRequestDispatcher("/home").include(request, response);
       
	}



}
