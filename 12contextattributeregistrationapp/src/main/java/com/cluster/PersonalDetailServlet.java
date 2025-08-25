package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
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
		String strAge = req.getParameter("age");
		String strPhone = req.getParameter("phone");

		ServletContext ctx = getServletContext();

		ctx.setAttribute("FIRST_NAME",strFirstName);
		ctx.setAttribute("SECOND_NAME",strSecondName);
		ctx.setAttribute("AGE",strAge);
		ctx.setAttribute("PHONE",strPhone);

		pw.println("<html>");
		pw.println("<body bgcolor='orange'>");
		pw.println("<form action='./prof' method='get'>");
		pw.println("<center><h2>PROFFESIONAL DETAILS</center>");
		pw.println("<table>");
		pw.println("<tr><td>Enter your current company name</td>");
		pw.println("<td><input type='text' name='companyName'></td></tr>");
		pw.println("<tr><td>Enter your previous company name</td>");
		pw.println("<td><input type='text' name='prevComp'></td></tr>");
		pw.println("<tr><td>Enter your current salary</td>");
		pw.println("<td><input type='text' name='salary'></td></tr>");
		pw.println("<tr><td>Enter your expected salary</td>");
		pw.println("<td><input type='text' name='expectedSal'></td></tr>");
		pw.println("<tr><td><input type='submit' value='Submit'></td></tr>");
		pw.println("</form></body></html>");
	}
}
