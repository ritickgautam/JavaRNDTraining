package com.Test;

import java.util.List;

import com.DAO.LanguageDAO;
import com.DAO.LanguageDAOImpl;
import com.Model.Country;
import com.Model.Language;

public class getAllLanguage {
	public static void main(String[] args) {
		LanguageDAO dao = new LanguageDAOImpl();
		List<Language> Languages = dao.getAllLanguage();
		for (Language l : Languages) {
			System.out.println("Language Name: " + l.getName());
			System.out.println("Language spoken by country/countries: ");
			List<Country> countries = l.getCountries();
			for (Country country : countries) {
				System.out.println(country.getName());
			}
			System.out.println("==============================");
		}
	}

}
