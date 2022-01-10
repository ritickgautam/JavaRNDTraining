package com.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Model.Language;

public class LanguageDAOImpl implements LanguageDAO {

	SessionFactory sf = new Configuration().configure("com/resources/hibernate.cfg.xml")
			.buildSessionFactory();


	@Override
	public void addLanguage(Language lang) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(lang);
		session.getTransaction().commit();

		System.out.println("Added Language "+ lang.getName()+" successfully");
		session.close();
	}

	@Override
	public List<Language> getAllLanguage() {
		Session session = sf.openSession();
		session.beginTransaction();
		 Query q = session.createQuery("From Language");
		 List<Language> Languages = q.getResultList();
		 session.getTransaction().commit();
		 session.close();
		return Languages;
	}

	@Override
	public Language getLanguage(int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.get(Language.class, id);
		Query q = session.createQuery("From Language where id=:id");
		q.setParameter("id", id);
		Language l = (Language) q.getSingleResult();

		session.getTransaction().commit();
		session.close();
		return l;
	}

}
