package com.appl;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomePage extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter write = res.getWriter();
		res.setContentType("text/html");
		HttpSession session = req.getSession(false);
		if (session != null) {
			String name = (String) session.getAttribute("username");
			write.print("<b>Hii</b>" + " " + "<b>" + name + "</b><br>");

			ServletContext application = getServletConfig().getServletContext();

			req.getRequestDispatcher("/addContact.html").include(req, res);

			ArrayList<String> list = Collections.list(application.getAttributeNames());

			for (String email : list) {
				String form = "\\w+@\\w+\\.\\w+";
				Pattern pat = Pattern.compile(form);
				Matcher match = pat.matcher(email);
				if (match.matches()) {
					ContactList contact = (ContactList) application.getAttribute(email);
					write.print(email + " ");
					write.print(contact.getName() + " ");
					write.print(contact.getPhoneNumber() + " ");
					write.print(contact.getAddress()+"<br>" );
                   
				}
			}

			req.getRequestDispatcher("/download.html").include(req, res);
			req.getRequestDispatcher("/logout.html").include(req, res);
		} else {
			write.print("please log in ");
			req.getRequestDispatcher("/index.html").include(req, res);
		}

	}
}
