package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NewUserServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		pw.println("<html>");
		pw.println("<body bgcolor='orange'>");
		pw.println("<h1>please enter your details</h1>");
		pw.println("<form action='./sign' method='post'>");
		pw.println("<table>");
		pw.println("<tr>");
		pw.println("<td>Enter your name</td>");
		pw.println("<td><input type='text' name='nme'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>Enter your password</td>");
		pw.println("<td><input type='password' name='pwd'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>Enter your Email</td>");
		pw.println("<td><input type='text' name='email'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>Enter your Phone</td>");
		pw.println("<td><input type='text' name='phone'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td colspan='2' align='center'><input type='submit' value='CLICK HERE'></td>");
		pw.println("</tr>");
		pw.println("</table>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
