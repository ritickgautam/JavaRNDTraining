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


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		UserService service = new UserServiceImpl();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		user user;
		try {
			user = service.authenticate(username,password);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			if(user!=null)
			{
						//user
						System.out.println("Logged in as : " + username +" " + password);
						RequestDispatcher rd = request.getRequestDispatcher("user");
						rd.forward(request, response);
			}
			else
			{
				
				System.out.println("User not exist");
				response.sendRedirect("index.jsp");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
