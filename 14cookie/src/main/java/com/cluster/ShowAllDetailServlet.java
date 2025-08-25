package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowAllDetailServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		Cookie[] ck = req.getCookies();

		pw.println("<html><body bgcolor ='pink'><form>");
		for (int i = 0; i < ck.length; i++) {
			pw.println("<h1>" + ck[i].getName() + "......" + ck[i].getValue() + "<br></h1>");
		}
		pw.println("</form></body></html>");
	}
}
