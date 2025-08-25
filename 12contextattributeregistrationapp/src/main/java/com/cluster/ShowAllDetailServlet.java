package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowAllDetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		ServletContext ctx = getServletContext();
		String strFirstName = (String) ctx.getAttribute("FIRST_NAME");

		pw.println("<html><body bgcolor ='pink'><form><table>");
		pw.println("<tr><td><h2>Personal Details</h2></td></tr>");
		pw.println("<tr><td>First Name</td>");
		pw.println("<td>" + strFirstName + "</td></tr>");
		pw.println("<tr><td>Second Name</td>");
		pw.println("<td>" + ctx.getAttribute("SECOND_NAME") + "</td></tr>");
		pw.println("<tr><td>Age</td>");
		pw.println("<td>" + ctx.getAttribute("AGE") + "</td></tr>");
		pw.println("<tr><td>Phone Number</td><td>" + ctx.getAttribute("PHONE") + "</td></TR>");

		pw.println("<tr><td><h2>Proffesional Details</h2></td></tr>");
		pw.println("<tr><td>Company Name</td>");
		pw.println("<td>" + ctx.getAttribute("COMPANY_NAME") + "</td></tr>");
		pw.println("<tr><td>Previous Company</td>");
		pw.println("<td>" + ctx.getAttribute("PRE_COMPANY_NAME") + "</td></tr>");
		pw.println("<tr><td>Salary</td>");
		pw.println("<td>" + ctx.getAttribute("SALARY") + "</td></tr>");
		pw.println("<tr><td>Expected Salary</td><td>" + ctx.getAttribute("EXP_SALARY") + "</td></tr>");

		pw.println("<tr><td><h2>Address Details</h2></td></tr>");
		pw.println("<tr><td>Street Name</td>");
		pw.println("<td>" + ctx.getAttribute("STREET") + "</td></tr>");
		pw.println("<tr><td>City Name</td>");
		pw.println("<td>" + ctx.getAttribute("CITY") + "</td></tr>");
		pw.println("<tr><td>State Name</td>");
		pw.println("<td>" + ctx.getAttribute("STATE") + "</td></tr>");
		pw.println("<tr><td>Country Name</td><td>" + ctx.getAttribute("COUNTRY") + "</td></tr>");
		pw.println("</table>");
		pw.println("</form></body></html>");
	}
}
