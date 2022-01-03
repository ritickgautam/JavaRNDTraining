package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.user;
import com.Service.UserService;
import com.Service.UserServiceImpl;

public class CreateUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		UserService service = new UserServiceImpl();
		String name = request.getParameter("name");
		long contact = Long.parseLong(request.getParameter("contact"));
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		user u=new user();
		u.setContact(contact);
		u.setEmail(email);
		u.setName(name);
		u.setUsername(username);
		u.setPassword(password);
		try {
			int status = service.reguser(u);
			if(status>0) {
				System.out.println("User added successfully");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				out.print("<h1>User added successfully</h1>");
				rd.include(request, response);
			}
			else {
				System.out.println("User not added");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				out.print("<h1>User not added</h1>");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.print("new id inserted in table: "+name+" "+contact+" "+email+" "+username+" "+password);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
