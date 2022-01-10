package com.Service;

import java.util.List;

import com.DAO.LanguageDAO;
import com.DAO.LanguageDAOImpl;
import com.Model.Language;

public class LanguageServiceImpl implements LanguageService {

	LanguageDAO dao = new LanguageDAOImpl();
	@Override
	public List<Language> getAllLanguage() {
		// TODO Auto-generated method stub
		return dao.getAllLanguage();
	}

	@Override
	public int addLanguage(Language lang) {
		// TODO Auto-generated method stub
		dao.addLanguage(lang);
		return 1;
	}

}
