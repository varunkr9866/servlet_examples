package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExistUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		res.setContentType("text/html");

		try {
			PrintWriter pw = res.getWriter();
			pw.println("<html>");
			pw.println("<body bgcolor='pink'>");
			pw.println("<h1>PLEASE ENTER VALUES</h1>");
			pw.println("<form action='./check' method='post'>");
			pw.println("<table>");
			pw.println("<tr>");
			pw.println("<td>ENTER YOUR EMAIL</td>");
			pw.println("<td><input type='text' name='email'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>ENTER YOUR PASSWORD</td>");
			pw.println("<td><input type=\"password\" name=\"pwd\"></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td><input type=\"submit\" value=\"LOGIN\"></td>");
			pw.println("</tr>");
			pw.println("<table>");
			pw.println("</body>");
			pw.println("</html>");
		} catch (IOException e) {
			System.out.println("Exception Caught" + e);
			e.printStackTrace();
		}
	}
}
