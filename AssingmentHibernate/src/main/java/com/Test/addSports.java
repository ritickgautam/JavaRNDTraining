package com.Test;

import com.DAO.SportDAO;
import com.DAO.SportDAOImpl;
import com.Model.Sport;

public class addSports {
	public static void main(String[] args) {
		SportDAO dao = new SportDAOImpl();
		Sport s1 = new Sport("Cricket");
		Sport s2 = new Sport("Hocket");
		Sport s3 = new Sport("Billiards");
		Sport s4 = new Sport("Football");
		Sport s5 = new Sport("Boxing");

		dao.addSport(s1);
		dao.addSport(s2);
		dao.addSport(s3);
		dao.addSport(s4);
		dao.addSport(s5);
	}

}
