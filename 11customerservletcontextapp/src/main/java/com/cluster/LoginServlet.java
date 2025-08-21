package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	Connection con;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("############Inside init() method");
		String strDriver = config.getInitParameter("driver");
		String strUrl = config.getInitParameter("dburl");
		String strUserId = config.getInitParameter("dbuid");
		String strPassword = config.getInitParameter("dbpwd");
		try {
			Class.forName(strDriver);
			con = DriverManager.getConnection(strUrl, strUserId,strPassword);
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		System.out.println("############Inside doPost() method");
		ResultSet rs = null;
		Statement st = null;
		boolean b = false;
		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		String strName = req.getParameter("nme");
		String strPassword = req.getParameter("pwd");

		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT NAME, PASSWORD FROM CUSTOMER");
			while (rs.next()) {
				if ((strName.equalsIgnoreCase(rs.getString("NAME")))&& (strPassword.equalsIgnoreCase(rs.getString("PASSWORD")))) {
					b = true;
					break;
				}
			}
			if (b) {
				writer.println("<html>");
				writer.println("<body bgcolor='green'>");
				writer.println("Hello Mr " + strName + " you are Welcome");
				writer.println("</body>");
				writer.println("</html>");
			} else {
				writer.println("<html>");
				writer.println("<body bgcolor='red'>");
				writer.println("Hello Mr " + strName + " you are invalid user");
				writer.println("</body>");
				writer.println("</html>");
			}
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		} 
		finally {
			try {
				if(rs!=null)
				{
				rs.close();
				}
				if(st!=null)
				{
				st.close();
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
