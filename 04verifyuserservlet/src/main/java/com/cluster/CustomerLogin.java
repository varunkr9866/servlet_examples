package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomerLogin extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		String strEmail = req.getParameter("email");
		String strPwd = req.getParameter("pwd");

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		boolean b = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
			System.out.println("Got The Connection");

			st = con.createStatement();
			rs = st.executeQuery("SELECT CUS_EMAIL,CUS_PASSWORD FROM CUSTOMER;");
			while (rs.next()) {
				if (strEmail.equalsIgnoreCase(rs.getString("CUS_EMAIL")) && strPwd.equalsIgnoreCase(rs.getString("CUS_PASSWORD"))) {
					b = true;
					break;
				}
			}
			if (b) 
			{
				pw.println("<html>");
				pw.println("<body bgcolor='red'>");
				pw.println("<h1>");
				pw.println("WELCOME TO CLUSTER SOLUTIONS");
				pw.println("</h1>");
				pw.println("</body>");
				pw.println("</html>");
			} else 
			{
				pw.println("<html>");
				pw.println("<body bgcolor='red'>");
				pw.println("<h1>");
				pw.println("PLEASE SIGIN YOU ARE NOT A MEMBER");
				pw.println("</h1>");
				pw.println("</body>");
				pw.println("</html>");
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception Caught :" + e);
			e.printStackTrace();
		} finally {
			try {
				con.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
