package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ShowAllDetailServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException
			, IOException {
		res.setContentType("text/html");
		PrintWriter
		pw = res.getWriter();

		HttpSession ses = req.getSession();
		String strFirstName = (String) ses.getAttribute("FIRST_NAME");

		pw.println("<html><body bgcolor ='pink'><form><table>");
		pw.println("<tr><td><h2>Personal Details</h2></td></tr>");
		pw.println("<tr><td>First Name</td>");
		pw.println("<td>" + strFirstName + "</td></tr>");
		pw.println("<tr><td>Second Name</td>");
		pw.println("<td>" + ses.getAttribute("SECOND_NAME") + "</td></tr>");
		pw.println("<tr><td>Age</td>");
		pw.println("<td>" + ses.getAttribute("AGE") + "</td></tr>");
		pw.println("<tr><td>Phone Number</td><td>" + ses.getAttribute("PHONE") + "</td></TR>");
		pw.println("<tr><td><h2>Proffesional Details</h2></td></tr>");
		pw.println("<tr><td>Company Name</td>");
		pw.println("<td>" + ses.getAttribute("COMPANY_NAME") + "</td></tr>");
		pw.println("<tr><td>Previous Company</td>");
		pw.println("<td>" + ses.getAttribute("PRE_COMPANY_NAME") + "</td></tr>");
		pw.println("<tr><td>Salary</td>");
		pw.println("<td>" + ses.getAttribute("SALARY") + "</td></tr>");
		pw.println("<tr><td>Expected Salary</td><td>"+ ses.getAttribute("EXP_SALARY") + "</td></tr>");
		pw.println("<tr><td><h2>Address Details</h2></td></tr>");
		pw.println("<tr><td>Street Name</td>");
		pw.println("<td>" + ses.getAttribute("STREET") + "</td></tr>");
		pw.println("<tr><td>City Name</td>");
		pw.println("<td>" + ses.getAttribute("CITY") + "</td></tr>");
		pw.println("<tr><td>State Name</td>");
		pw.println("<td>" + ses.getAttribute("STATE") + "</td></tr>");
		pw.println("<tr><td>Country Name</td><td>"+ ses.getAttribute("COUNTRY") + "</td></tr>");
		pw.println("</table>");
		pw.println("</form></body></html>");
		// session.invalidate(); 
	}

}
