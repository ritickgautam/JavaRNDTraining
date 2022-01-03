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

import com.Model.product;
import com.Service.ProductService;
import com.Service.ProductServiceImpl;

/**
 * Servlet implementation class EditProductServlet
 */
public class EditProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int pid=Integer.parseInt(request.getParameter("act"));
		ProductService pservice = new ProductServiceImpl();
		HttpSession session = request.getSession(false);
		try {
			product p = pservice.findproductBypid(pid);
			session.setAttribute("product", p);
			System.out.println("Product included in session");
			RequestDispatcher rd = request.getRequestDispatcher("user-home.jsp?act=edit");
			
			rd.include(request, response);
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
