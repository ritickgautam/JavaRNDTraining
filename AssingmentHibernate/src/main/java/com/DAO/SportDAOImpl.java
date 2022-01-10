package com.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Model.Language;
import com.Model.Sport;

public class SportDAOImpl implements SportDAO {

	SessionFactory sf = new Configuration().configure("com/resources/hibernate.cfg.xml")
			.buildSessionFactory();


	@Override
	public void addSport(Sport sport) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(sport);
		session.getTransaction().commit();

		System.out.println("Added Sport "+ sport.getName()+" successfully");
		session.close();

	}

	@Override
	public List<Sport> getSports() {
		Session session = sf.openSession();
		session.beginTransaction();
		 Query q = session.createQuery("From Sport");
		 List<Sport> sports = q.getResultList();
		 session.getTransaction().commit();
		 session.close();
		return sports;
	}

	@Override
	public Sport getSportById(int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.get(Language.class, id);
		Query q = session.createQuery("From Sport where id=:id");
		q.setParameter("id", id);
		Sport s = (Sport) q.getSingleResult();

		session.getTransaction().commit();
		session.close();
		return s;
	}

}
