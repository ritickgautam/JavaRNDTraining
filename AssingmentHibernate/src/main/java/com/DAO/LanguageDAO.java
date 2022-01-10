package com.DAO;

import java.util.List;

import com.Model.Language;

public interface LanguageDAO {
	public void addLanguage(Language lang);
	public List<Language> getAllLanguage();
	public Language getLanguage(int id);

}
