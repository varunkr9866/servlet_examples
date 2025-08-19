package com.cluster;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustmerServlet extends HttpServlet{
		public void doGet(HttpServletRequest req, HttpServletResponse res) 
				throws ServletException, IOException {
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			
			String strNme =req.getParameter("nme");
			String strPwd =req.getParameter("pwd");
			String strEml =req.getParameter("eml");
			String strNum =req.getParameter("num");
			
			
		}
}
