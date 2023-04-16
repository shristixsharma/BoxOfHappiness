package com.nt.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register") //annotation maps servlet to web files
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //when we send data use post method, get to get data 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("name"); //getParameter is method to get form data from jsp,html files
		String uemail=request.getParameter("email");
		String upwd=request.getParameter("pass");
		String umobile=request.getParameter("contact");
		RequestDispatcher dispatcher=null;
		//reuestDispatcher sends data from one servle to another
		Connection con=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shristi?useSSL=false","root","root");
		PreparedStatement ps=con.prepareStatement("insert into users(uname,upwd,uemail,umobile) values(?,?,?,?)");
		ps.setString(1, uname);
		ps.setString(2, upwd);
		ps.setString(3, uemail);
		ps.setString(4, umobile);
;
		int rowCount=ps.executeUpdate();
		dispatcher=request.getRequestDispatcher("registration.jsp");
		if(rowCount>0) {
			request.setAttribute("status","success");
		}
		else {
			request.setAttribute("status","failed");}
		dispatcher.forward(request,response);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}}
