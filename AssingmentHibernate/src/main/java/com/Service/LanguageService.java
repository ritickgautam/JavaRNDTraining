package com.Service;

import java.util.List;

import com.Model.Language;

public interface LanguageService {

	public List<Language> getAllLanguage();
	public int addLanguage(Language lang);

}
