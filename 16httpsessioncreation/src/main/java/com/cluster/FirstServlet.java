package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<html>");
		pw.println("<body bgcolor='yellow'>");
		pw.println("<form action='./two'>");
		pw.println("<input type='submit' value='SECOND'>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
