package com.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Model.Capital;

public class CapitalDAOImpl implements CapitalDAO {

	SessionFactory sf = new Configuration().configure("com/resources/hibernate.cfg.xml")
			.buildSessionFactory();


	@Override
	public void addCapital(Capital capital) {


		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(capital);
		session.getTransaction().commit();
		System.out.println("Added Capital "+ capital.getName()+" successfully");
		session.close();

	}

	@Override
	public Capital findCapitalById(int id) {


		Session session = sf.openSession();
		session.beginTransaction();
		session.get(Capital.class, id);
		Query q = session.createQuery("From Capital where id=:id");
		q.setParameter("id", id);
		Capital c = (Capital) q.getSingleResult();

		session.getTransaction().commit();
		session.close();
		return c;
	}

	@Override
	public int removeCapitalByID(int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		Capital c = session.get(Capital.class, id);
		session.delete(c);
		session.getTransaction().commit();
		session.close();

		return 0;
	}

	@Override
	public int updateCapital(Capital capital) {
		Session session = sf.openSession();
		session.beginTransaction();
		int id = capital.getId();
		String name = capital.getName();
		capital.setId(id);
		capital.setName(name);
		session.saveOrUpdate(capital);
		session.close();
		return 0;
	}

	@Override
	public List<Capital> getCapitals() {
		Session session = sf.openSession();
		session.beginTransaction();
		 Query q = session.createQuery("From Capital");
		 List<Capital> capitals = q.getResultList();
		 session.getTransaction().commit();
		 session.close();
		return capitals;
	}


}
