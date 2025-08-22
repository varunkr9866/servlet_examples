package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddressDetailServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String strStreet = req.getParameter("street");
		String strCity = req.getParameter("city");

		Cookie cookie5 = new Cookie("STREET", strStreet);
		Cookie cookie6 = new Cookie("CITY", strCity);
		res.addCookie(cookie5);
		res.addCookie(cookie6);
		
		Cookie []ck = req.getCookies();
		
		pw.println("<html><body bgcolor='orange'>");
		for(int i=0;i < ck.length;i++){
			pw.println("<h1>" + ck[i].getName()+ "......" + ck[i].getValue()+"<br></h1>");
		}
		pw.println("<form action='./show' method='get'>");
		pw.println("<input type ='submit' value='CLICK TO SEE ALL DETAILS'>");
		pw.println("</form></body></html>");
	}
}
