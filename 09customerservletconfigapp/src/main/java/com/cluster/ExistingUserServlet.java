package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExistingUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<html>");
		pw.println("<body bgcolor='yellow'>");
		pw.println("<h1>please enter your details</h1>");
		pw.println("<form action='./check' method='post'>");
		pw.println("<table>");
		pw.println("<tr>");
		pw.println("<td>Enter your Name</td>");
		pw.println("<td><input type='text' name='nme'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>Enter your Password</td>");
		pw.println("<td><input type='password' name='pwd'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td colspan='2' align='center'><input type='submit' value='Click Here'></td>");
		pw.println("</tr>");
		pw.println("</table>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
