package com.Test;

import com.DAO.LanguageDAO;
import com.DAO.LanguageDAOImpl;
import com.Model.Language;

public class addLanguage {
	public static void main(String[] args) {
		LanguageDAO dao = new LanguageDAOImpl();
		Language l1 = new Language("English");
		l1.setId(1);
		Language l2 = new Language("Hindi");
		l2.setId(2);
		Language l3 = new Language("Urdu");
		l3.setId(3);

		dao.addLanguage(l1);
		dao.addLanguage(l2);
		dao.addLanguage(l3);


	}

}
