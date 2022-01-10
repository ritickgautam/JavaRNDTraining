package com.Service;

import java.util.List;

import com.DAO.CountryDAO;
import com.DAO.CountryDAOImpl;
import com.Model.Country;

public class CountryServiceImpl implements CountryService {
	CountryDAO dao= new CountryDAOImpl();
	@Override
	public List<Country> getAllCountry() {

		return dao.getAllCountry();
	}

	@Override
	public int addCountry(Country c) {
		dao.addCountry(c);
		return 1;
	}

}
