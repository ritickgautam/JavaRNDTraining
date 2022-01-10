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

import com.Model.Language;
import com.Service.LanguageService;
import com.Service.LanguageServiceImpl;

/**
 * Servlet implementation class getAllLangs
 */
public class getAllLangs extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			LanguageService service = new LanguageServiceImpl();
			List<Language> languages = service.getAllLanguage();
			HttpSession session = request.getSession(false);
			session.setAttribute("languages", languages);
			RequestDispatcher rd = request.getRequestDispatcher("showListLanguages.jsp");
			rd.forward(request, response);
		}

		@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
