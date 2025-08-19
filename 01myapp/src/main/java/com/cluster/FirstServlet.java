package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<html>");
		pw.println("<body bgcolor='pink'>");
		pw.println("<h1>");
		pw.println("Hello World");
		pw.println("<br/>");
		pw.println("This Is My First Servlet Program");
		pw.println("</h1>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
