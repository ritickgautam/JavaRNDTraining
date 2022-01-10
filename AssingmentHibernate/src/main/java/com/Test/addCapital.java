package com.Test;

import com.DAO.CapitalDAO;
import com.DAO.CapitalDAOImpl;
import com.Model.Capital;

public class addCapital {
	public static void main(String[] args) {
		CapitalDAO dao = new CapitalDAOImpl();
		Capital c1 = new Capital("Delhi");
		c1.setId(1);
		Capital c2 = new Capital("Kathmandu");
		c2.setId(2);
		Capital c3 = new Capital("Lahore");
		c3.setId(3);
		Capital c4 = new Capital("Toranto");
		c4.setId(4);

		dao.addCapital(c1);
		dao.addCapital(c2);
		dao.addCapital(c3);
		dao.addCapital(c4);

	}

}
