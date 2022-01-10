package com.Test;

import java.util.List;

import com.DAO.CapitalDAO;
import com.DAO.CapitalDAOImpl;
import com.DAO.CountryDAO;
import com.DAO.CountryDAOImpl;
import com.DAO.LanguageDAO;
import com.DAO.LanguageDAOImpl;
import com.DAO.SportDAO;
import com.DAO.SportDAOImpl;
import com.Model.Capital;
import com.Model.Country;
import com.Model.Language;
import com.Model.Sport;

public class addCountry {
	public static void main(String[] args) {
		System.out.println("Adding country..");
		CountryDAO dao = new CountryDAOImpl();
		CapitalDAO cdao = new CapitalDAOImpl();
		LanguageDAO ldao = new LanguageDAOImpl();
		SportDAO sdao = new SportDAOImpl();

		String countryName1 = "India";
		String countryName2 = "Pakistan";
		String countryName3 = "Canada";
		String countryName4 = "Nepal";

		Capital c1 = cdao.findCapitalById(1);
		Capital c2 = cdao.findCapitalById(2);
		Capital c3 = cdao.findCapitalById(3);
		Capital c4 = cdao.findCapitalById(4);

		Language l1 = ldao.getLanguage(1);
		Language l2 = ldao.getLanguage(2);
		Language l3 = ldao.getLanguage(3);

		Sport s1 = sdao.getSportById(1);
		Sport s2 = sdao.getSportById(2);
		Sport s3 = sdao.getSportById(3);
		Sport s4 = sdao.getSportById(4);
		Sport s5 = sdao.getSportById(5);

		Country country1= new Country();
		country1.setId(1);
		Country country2= new Country();
		country2.setId(2);
		Country country3= new Country();
		country3.setId(3);
		Country country4= new Country();
		country4.setId(4);

		country1.setName(countryName1);
		country2.setName(countryName2);
		country3.setName(countryName3);
		country4.setName(countryName4);


		country1.setCapital(c1);
		country2.setCapital(c3);
		country3.setCapital(c4);
		country4.setCapital(c2);

		country1.setLanguage(l2);
		country2.setLanguage(l3);
		country3.setLanguage(l1);
		country4.setLanguage(l2);

		country1.addSport(s1);
		country1.addSport(s3);
		country2.addSport(s4);
		country2.addSport(s2);
		country3.addSport(s1);
		country4.addSport(s5);

		List<Sport> country1sports = country1.getSports();
		List<Sport> country2sports = country2.getSports();
		List<Sport> country3sports = country3.getSports();
		List<Sport> country4sports = country4.getSports();

		country1.setSports(country1sports);
		country2.setSports(country2sports);
		country3.setSports(country3sports);
		country4.setSports(country4sports);

		dao.addCountry(country1);
		dao.addCountry(country2);
		dao.addCountry(country3);
		dao.addCountry(country4);



	}
}
