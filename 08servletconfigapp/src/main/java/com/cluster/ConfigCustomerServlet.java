package com.cluster;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConfigCustomerServlet {
		Connection con = null;
		public void init(ServletConfig config){
			String StrDriver = config.getInitParameter("driver");
			String StrUrl = config.getInitParameter("dburl");
			String StrUn = config.getInitParameter("dbuid");
			String StrPwd = config.getInitParameter("dbpwd");
			try {
				Class.forName("StrDriver");
				con =DriverManager.getConnection(StrUrl, StrUn, StrPwd);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Exception Caught :"+ e);
				e.printStackTrace();
			}
		}
		
		public void service(HttpServletRequest req ,HttpServletResponse res) {
			
			String strName = req.getParameter("nme"); 
			String strPwd = req.getParameter("pwd"); 
			String strEmail = req.getParameter("email"); 
			String strPhone = req.getParameter("phone"); 
			res.setContentType("text/html");
			PreparedStatement pst = null;
			
			
			try {
				PrintWriter pw = res.getWriter();
				int i= 0;
				pst = con.prepareStatement("INSERT INTO CUSTOMER (CUS_NAME,CUS_PASSWORD,CUS_EMAIL,CUS_PHONE) VALUES(?,?,?,?)");
				
				pst.setString(1, strName);
				pst.setString(1, strPwd);
				pst.setString(1, strEmail);
				pst.setString(1, strPhone);
				i =pst.executeUpdate();
				
				if (i == 1) {
					
				} else {

				}
			} catch (SQLException | IOException e) {
				System.out.println("Exception Caught :"+ e);
				e.printStackTrace();
			}
			
		}
}
