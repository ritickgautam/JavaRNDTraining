package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.Country;
import com.Service.CountryService;
import com.Service.CountryServiceImpl;

/**
 * Servlet implementation class GetAllCountry
 */
public class GetAllCountry extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		CountryService service = new CountryServiceImpl();
		List<Country> countries = service.getAllCountry();
//		for (Country country : countries) {
//			List<Sport> sports = country.getSports();
//			out.println("Country name: "+country.getName()
//			+ " Capital Name: "+ country.getCapital().getName()
//			+ " Language spoken " + country.getLanguage().getName()
//			+" Sports played " );
//			for (Sport sport : sports) {
//				out.println(sport.getName());
//			}
//		}
		HttpSession session = request.getSession(false);
		session.setAttribute("countries", countries);
		RequestDispatcher rd = request.getRequestDispatcher("showListCountry.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
