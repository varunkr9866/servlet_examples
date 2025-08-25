package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String strEmail = req.getParameter("email");

		HttpSession ses = req.getSession();
		
		pw.println("<html>");
		pw.println("<body bgcolor='pink'>");
		pw.println("<form>");
		pw.println("<h1>");
		pw.println("Email is " + strEmail + "<br></h1>");
		pw.println("<a href="+res.encodeURL("./html/abc.html")+">Click me for ABC </a><br>");
		pw.println("<a href='./html/xyz.html'>Click me for XYZ</a><br>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
