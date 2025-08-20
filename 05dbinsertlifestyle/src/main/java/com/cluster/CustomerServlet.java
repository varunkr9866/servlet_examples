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
		Connection con= null;
		public void init(ServletConfig config) throws ServletException {
			System.out.println("############# inside init method ");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Is Loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
				System.out.println("^^^^^^^^^^^ inside init :"+ con);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Caught Exception :" + e);
				e.printStackTrace();
			}
		}
		public void doPost(HttpServletRequest req, HttpServletResponse res) 
				throws ServletException, IOException {
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			
			String strName = req.getParameter("nme");
			String strPwd = req.getParameter("pwd");
			String strEmail = req.getParameter("email");
			String strPhone = req.getParameter("phone");
			
			PreparedStatement pst = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Is Loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
				System.out.println("Connection Established");
				pst = con.prepareStatement("INSERT INTO CUSTOMER (CUS_NAME,CUS_PASSWORD,CUS_EMAIL,CUS_PHONE) VALUES(?,?,?,?);");
				pst.setString(1, strName);
				pst.setString(2, strPwd);
				pst.setString(3, strEmail);
				pst.setString(4, strPhone);
				int x = pst.executeUpdate();
				
				if (x == 1) {
					pw.println("<html>");
					pw.println("<body bgcolor='pink'>");
					pw.println("WELCOME TO CLUSTER SOLUTIONS");
					pw.println("</body>");
					pw.println("</html>");
				} else {
					pw.println("html");
					pw.println("<body bgcolor='red'>");
					pw.println("SORRY NO ACCESS");
					pw.println("</body>");
					pw.println("</html>");
				}

				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					con.close();
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
