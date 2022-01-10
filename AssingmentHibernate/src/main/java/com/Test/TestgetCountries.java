package com.Test;

import java.util.List;

import com.DAO.CountryDAO;
import com.DAO.CountryDAOImpl;
import com.Model.Country;

public class TestgetCountries {
	public static void main(String[] args) {
		CountryDAO dao = new CountryDAOImpl();
		List<Country> countries = dao.getAllCountry();
		for (Country country : countries) {
			System.out.println("Country name: "+country.getName()
					+ " Capital Name: "+ country.getCapital().getName()
					+ " Language spoken " + country.getLanguage().getName()
					+" Sports played " +country.getSports());
		}
	}

}
