package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustmerServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		String strNme = req.getParameter("nme");
		String strPwd = req.getParameter("pwd");
		String strEml = req.getParameter("email");
		String strNum = req.getParameter("phone");

		Connection con = null;
		PreparedStatement pst = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/varunmysql", "root", "Cluster");
			pst = con.prepareStatement("INSERT INTO CUSTOMER (NAME,PASSWORD,EMAIL,PHONE) VALUES(?,?,?,?);");
			pst.setString(1, strNme);
			pst.setString(2, strPwd);
			pst.setString(3, strEml);
			pst.setString(4, strNum);
			int x = pst.executeUpdate();

			if (x == 1) {
				pw.println("html");
				pw.println("body bgcolor='pink'");
				pw.println("WELCOME TO CLUSTER SOLUTIONS");
				pw.println("/body");
				pw.println("/html");
			} else {
				pw.println("html");
				pw.println("body bgcolor='red'");
				pw.println("SORRY NO ACCESS");
				pw.println("/body");
				pw.println("/html");
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Caught Exception :" + e);
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
