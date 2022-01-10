package com.DAO;

import java.util.List;

import com.Model.Capital;

public interface CapitalDAO {

	public void addCapital(Capital capital);
	public int removeCapitalByID(int id);
	public int updateCapital(Capital capital);
	public Capital findCapitalById(int id);
	public List<Capital> getCapitals();
}
