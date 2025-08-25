package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddressDetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		String strStreet = req.getParameter("street");
		String strCity = req.getParameter("city");
		String strState = req.getParameter("state");
		String strCountry = req.getParameter("country");

		ServletContext ctx = getServletContext();

		ctx.setAttribute("STREET", strStreet);
		ctx.setAttribute("CITY", strCity);
		ctx.setAttribute("STATE", strState);
		ctx.setAttribute("COUNTRY", strCountry);

		pw.println("<html><body bgcolor='orange'>");
		pw.println("<form action='./show' method='get'>");
		pw.println("<input type ='submit' value='CLICK TO SEE ALL DETAILS'>");
		pw.println("</form></body></html>");
	}

}
