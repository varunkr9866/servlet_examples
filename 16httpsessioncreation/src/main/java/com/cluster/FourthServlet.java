package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FourthServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		HttpSession ses = req.getSession();
		
		pw.println("<html>");
		pw.println("<body bgcolor='wheat'>");
		pw.println("<form action='./third'>");
		pw.println("Session is new "+ses.isNew()+"<br>");
		pw.println("Session id is "+ses.getId()+"<br>");
		pw.println("Session last accessed time is "+ new Date(ses.getLastAccessedTime())+"<br>");
		pw.println("Session created time is " +new Date(ses.getCreationTime())+"<br>");
		pw.println("Session max inactive interval time is "+ses.getMaxInactiveInterval()+"<br>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
