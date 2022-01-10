package com.DAO;

import java.util.List;

import com.Model.Sport;

public interface SportDAO {
	public void addSport(Sport sport);
	public List<Sport> getSports();
	public Sport getSportById(int id);


}
