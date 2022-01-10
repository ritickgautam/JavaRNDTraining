package com.Service;

import java.util.List;

import com.Model.Country;

public interface CountryService {

	public List<Country> getAllCountry();
	public int addCountry(Country c);

}
