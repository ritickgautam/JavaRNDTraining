package com.DAO;

import java.util.List;

import com.Model.Country;

public interface CountryDAO {
	public List<Country> getAllCountry();
	public void addCountry(Country c);
	public Country getCountry(int id);

}
