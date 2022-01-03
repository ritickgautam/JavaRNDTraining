package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.product;
import com.Model.user;
import com.Service.ProductService;
import com.Service.ProductServiceImpl;

/**
 * Servlet implementation class NewProductServlet
 */
public class NewProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ProductService pservice = new ProductServiceImpl();
		product p = new product();
		HttpSession session = request.getSession(false);
		user u = (user) session.getAttribute("user");
		int userid = u.getId();
		String pName = request.getParameter("pname");
		Double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String vendor = request.getParameter("vendor");
		int warranty = Integer.parseInt(request.getParameter("warranty"));
		
		p.setpName(pName);
		p.setPrice(price);
		p.setQuantity(quantity);
		p.setVendor(vendor);
		p.setWarranty(warranty);
		p.setUserid(userid);
		
		try {
			int status = pservice.save(p);
			List<product> products = pservice.findproductByuserid(userid);
			session.setAttribute("products", products);
			if(status>0) {
				System.out.println("Product added successfully : " +userid+" "+p.getPid()+" " + pName +" "+ price +" "+ quantity + " "+ vendor + " " + warranty);
				RequestDispatcher rd = request.getRequestDispatcher("user-home.jsp?act=show");
				out.print("<h1>Product added successfully</h1>");
				rd.include(request, response);
			}
			else {
				System.out.println("Product not added");
				RequestDispatcher rd = request.getRequestDispatcher("user-home.jsp?act=add");
				out.print("<h1>User not added try again</h1>");
				rd.include(request, response);
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
