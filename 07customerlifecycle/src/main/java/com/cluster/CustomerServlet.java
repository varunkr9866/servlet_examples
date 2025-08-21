package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomerServlet extends HttpServlet{
	Connection con;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("############Inside init() method");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("got the driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
			System.out.println("Connection Established");
			} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		System.out.println("############Inside doPost() method");
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String strNme = req.getParameter("nme");
		String strPwd = req.getParameter("pwd");
		String strEmail = req.getParameter("email");
		String strPhone = req.getParameter("phone");
		
		PreparedStatement pst = null;
		
		try {
			pst = con.prepareStatement("INSERT INTO CUSTOMER(NAME,PASSWORD,EMAIL,PHONE) VALUES (?,?,?,?)");
			pst.setString(1, strNme);
			pst.setString(2, strPwd);
			pst.setString(3, strEmail);
			pst.setString(4, strPhone);
			
			int i = pst.executeUpdate();
			
			if (i==1)
			{
				pw.println("<html>");
				pw.println("<body bgcolor='green'>");
				pw.println("Hello Mr " + strNme + " Thank you for becoming a member");
				pw.println("</body>");
				pw.println("</html>");
			}
			
			else
			{
				pw.println("<html>");
				pw.println("<body bgcolor='red'>");
				pw.println("Hello Mr " + strNme + " Better luck next time");
				pw.println("</body>");
				pw.println("</html>");
			}
			
		}  catch (SQLException e) {
			System.out.println("Exception caught " + e);
			e.printStackTrace();
		}
		
		finally{
			try {
				
				if(pst!=null)
				{
				pst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void destroy() {
		System.out.println("############Inside destroy() method");
		try {
			con.close();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}
}
