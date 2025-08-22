package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProfessionalDetailServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		String strCompanyName = req.getParameter("companyName");
		String strSalary = req.getParameter("salary");

		Cookie cookie3 = new Cookie("COMPANY_NAME", strCompanyName);
		Cookie cookie4 = new Cookie("SALARY", strSalary);
		res.addCookie(cookie3);
		res.addCookie(cookie4);

		Cookie[] ck = req.getCookies();

		pw.println("<html>");
		pw.println("<body bgcolor='yellow'>");
		for (int i = 0; i < ck.length; i++) {
			pw.println("<h1>" + ck[i].getName() + "......"
					+ ck[i].getValue() + "<br></h1>");
		}
		pw.println("<form action='./add' method='get'>");
		pw.println("<center><h2>ADDRESS DETAILS</center>");
		pw.println("<table>");
		pw.println("<tr><td>Enter your street</td>");
		pw.println("<td><input type='text' name='street'></td></tr>");
		pw.println("<tr><td>Enter your city</td>");
		pw.println("<td><input type='text' name='city'></td></tr>");
		pw.println("<tr><td colspan='2' align='center'><input type='submit' value='Submit'></td></tr>");
		pw.println("</form></body></html>");

	}
}
