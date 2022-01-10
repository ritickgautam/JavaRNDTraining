package com.Test;

import java.util.List;

import com.DAO.CountryDAO;
import com.DAO.CountryDAOImpl;
import com.Model.Country;
import com.Model.Sport;

public class getAllCountry {
	public static void main(String[] args) {
		CountryDAO dao = new CountryDAOImpl();
		List<Country> countries = dao.getAllCountry();
		for (Country c : countries) {
			System.out.println("Country Name: " + c.getName());
			System.out.println("Capital City: " + c.getCapital().getName());
			System.out.println("Language spoken: " + c.getLanguage().getName());
			List<Sport> sports = c.getSports();
			System.out.println("Sports played: ");
			for (Sport sport : sports) {
				System.out.println(sport.getName());
			}
			System.out.println("==============================");
		}
	}

}
