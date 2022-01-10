package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Model.Country;

public class CountryDAOImpl implements CountryDAO {

	SessionFactory sf = new Configuration().configure("com/resources/hibernate.cfg.xml")
			.buildSessionFactory();
	@Override
	public List<Country> getAllCountry() {
		Session session = sf.openSession();
		session.beginTransaction();
		 Query q = session.createQuery("From Country");
		 List<Country> countries = q.list();
		 session.getTransaction().commit();
		 session.close();
		return countries;

	}
	@Override
	public void addCountry(Country c) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(c);
		session.getTransaction().commit();
		System.out.println("Added country "+ c.getName()+" successfully");
		session.close();

	}
	@Override
	public Country getCountry(int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.get(Country.class, id);
		Query q = session.createQuery("From Country where id=:id");
		q.setParameter("id", id);
		Country c = (Country) q.getSingleResult();

		session.getTransaction().commit();
		session.close();
		return c;
	}

}
