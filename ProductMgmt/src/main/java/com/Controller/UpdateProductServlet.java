package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.product;
import com.Model.user;
import com.Service.ProductService;
import com.Service.ProductServiceImpl;

public class UpdateProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ProductService pservice = new ProductServiceImpl();
		HttpSession session = request.getSession(false);
		product p = new product();
		p= (product) session.getAttribute("product");
		System.out.println(p.getPid());
		
		
		user u = (user) session.getAttribute("user");
		int userid = u.getId();
		int pid = p.getPid();
		String pName = request.getParameter("pname");
		Double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String vendor = request.getParameter("vendor");
		int warranty = Integer.parseInt(request.getParameter("warranty"));
		p.setPid(pid);
		p.setpName(pName);
		p.setPrice(price);
		p.setQuantity(quantity);
		p.setVendor(vendor);
		p.setWarranty(warranty);
		p.setUserid(userid);
		try {
			int status = pservice.updateProduct(p);
			if(status>0) {
				System.out.println("updated successfully record " + pid + " " + pName + " " + price + " " + quantity + " " + warranty + " " + vendor);
				out.print("<h3>Record updated successfully</h3>");
				List<product> products = pservice.findproductByuserid(userid);
				session.setAttribute("products", products);
				
				request.getRequestDispatcher("user-home.jsp?act=show").include(request, response);
			}
			else {
				out.print("<h1>Not updated Record</h1>");
				System.out.println("Record not updated");
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
