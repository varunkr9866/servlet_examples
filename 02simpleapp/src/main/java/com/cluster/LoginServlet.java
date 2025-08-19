package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		String strNme = req.getParameter("nme");
		String strPwd = req.getParameter("pwd");

		if (strNme.equalsIgnoreCase("ravi") && strPwd.equalsIgnoreCase("amog")) {
			pw.println("<html>");
			pw.println("<body bgcolor='pink'>");
			pw.println("Hello MR." + strNme + "You Are Welcome");
			pw.println("</body>");
			pw.println("</html>");

		} else {
			pw.println("<html>");
			pw.println("<body bgcolor='pink'>");
			pw.println("Hello MR." + strNme + "You Are Invalid User");
			pw.println("</body>");
			pw.println("</html>");
		}
	}
}
