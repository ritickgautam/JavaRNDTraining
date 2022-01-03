package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.jsp.PageContext;

import com.Model.product;
import com.Model.user;
import com.Service.ProductService;
import com.Service.ProductServiceImpl;

/**
 * Servlet implementation class DeleteProductServlet
 */
public class DeleteProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int pid=Integer.parseInt(request.getParameter("act"));
		ProductService pservice = new ProductServiceImpl();
		
		HttpSession session = request.getSession(false);
		user u = (user) session.getAttribute("user");
		int userid = u.getId();
		
		try {
			int status = pservice.deleteProduct(pid);
			if(status>0) {
				
				out.print("<h1>Product deleted successfully</h1>");
				List<product> products = pservice.findproductByuserid(userid);
				session.setAttribute("products", products);
				RequestDispatcher rd = request.getRequestDispatcher("user-home.jsp?act=show");
				rd.include(request, response);
				System.out.println("Deleted productid: "+ pid );
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("user-home.jsp");
				out.print("<h1>Product not deleted successfully</h1>");
				rd.include(request, response);
				System.out.println("Product not deleted");
				
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
