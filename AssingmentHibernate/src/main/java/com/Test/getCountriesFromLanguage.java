package com.Test;

import java.util.List;

import com.DAO.LanguageDAO;
import com.DAO.LanguageDAOImpl;
import com.Model.Country;
import com.Model.Language;

public class getCountriesFromLanguage {
	public static void main(String[] args) {
	LanguageDAO ldao = new LanguageDAOImpl();
	Language l = ldao.getLanguage(2);
	System.out.println("Countries who speak " + l.getName());
	List<Country> countries = l.getCountries();
	for (Country country : countries) {
		System.out.println("Country: "+country.getName());
	}
	}

}
