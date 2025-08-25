package com.cluster;

import jakarta.servlet.http.HttpServlet;

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
		pw.println("<a href="+res.encodeUrl("./html/abc.html")+">Click me for ABC </a><br>");
		pw.println("<a href='./html/xyz.html'>Click me for XYZ</a><br>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
