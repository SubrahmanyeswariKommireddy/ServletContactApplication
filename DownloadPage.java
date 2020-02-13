package com.appl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadPage extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/csv");
		String reportName = "GenerateCSV_Report_" + System.currentTimeMillis() + ".csv";
		response.setHeader("Content-disposition", "attachment; " + "filename=" + reportName);
		PrintWriter write = response.getWriter();
		ServletContext application = request.getServletContext();
		ArrayList<String> list = Collections.list(application.getAttributeNames());
        write.println("Name,Email,PhoneNumber,Address");
		for (String email : list) {
			String form = "\\w+@\\w+\\.\\w+";
			Pattern pat = Pattern.compile(form);
			Matcher match = pat.matcher(email);
			if (match.matches()) {
				ContactList contact=(ContactList) application.getAttribute(email);
				write.print(contact.getName() + ",");
				write.print(contact.getEmail() + ",");
				write.print(contact.getPhoneNumber() + ",");
				write.print(contact.getAddress());
				write.println();

			}
			
		}
        
		
	}

}
