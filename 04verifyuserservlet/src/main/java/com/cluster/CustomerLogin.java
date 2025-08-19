package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomerLogin extends HttpServlet{
		public void doPost(HttpServletRequest req, HttpServletResponse res) 
				throws ServletException, IOException {
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
		}
}
