package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PersonalDetailServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String strFirstName = req.getParameter("firstName");
		String strSecondName = req.getParameter("secondName");

		// create the cookie object
		Cookie cookie1  = new Cookie("FIRST_NAME",strFirstName);
		Cookie cookie2 = new Cookie("SECOND_NAME",strSecondName);
		
		cookie1.setMaxAge(30);
		int i = cookie1.getMaxAge();
		int j = cookie2.getMaxAge();
		System.out.println("Value of cookie1 max age is******" + i);
		System.out.println("Value of cookie1 max age is******" + j);
		
		
		// add the cookie to the response object
		res.addCookie(cookie1);
		res.addCookie(cookie2);

		pw.println("<html>");
		pw.println("<body bgcolor='orange'>");
		pw.println("<form action='./prof' method='get'>");
		pw.println("<center><h2>PROFFESIONAL DETAILS</center>");
		pw.println("<table>");
		pw.println("<tr><td>Enter your current company name</td>");
		pw.println("<td><input type='text' name='companyName'></td></tr>");
		pw.println("<tr><td>Enter your current salary</td>");
		pw.println("<td><input type='text' name='salary'></td></tr>");
		pw.println("<tr><td><input type='submit' value='Submit'></td></tr>");
		pw.println("</form></body></html>");
	}
}
