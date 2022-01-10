package com.Test;

import java.util.List;

import com.DAO.CapitalDAO;
import com.DAO.CapitalDAOImpl;
import com.Model.Capital;

public class TestCapital {
public static void main(String[] args) {
	CapitalDAO dao = new CapitalDAOImpl();
	Capital c = new Capital();
	c.setName("Delhi");
	dao.addCapital(c);

//	Capital c1 = dao.findCapitalById(1);
//	System.out.println(c1);

	List<Capital> capitals = dao.getCapitals();
	for (Capital capital : capitals) {
		System.out.println(capital);
	}
}

}
