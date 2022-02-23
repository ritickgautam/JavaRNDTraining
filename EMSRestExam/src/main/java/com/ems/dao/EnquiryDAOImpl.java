<<<<<<< HEAD
package com.ems.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.model.Enquiry;

@Repository
public class EnquiryDAOImpl implements EnquiryDAO {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Enquiry> getQueries() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Enquiry.class);
		criteria.addOrder(Order.asc("enquiryId"));
		List<Enquiry> queries = criteria.list();
		return queries;
	}


	@Override
	public Enquiry getQueryById(int id) {
		Session session = sessionFactory.openSession();
		Enquiry enquiry =session.get(Enquiry.class, id);
		return enquiry;
	}

	@Override
	public List<Enquiry> getQueriesByUserId(int userId) {
		String hql = "SELECT e FROM " + Enquiry.class + " e WHERE e.id =:userId";

		Session session = sessionFactory.openSession();
		Query<Enquiry> query = session.createQuery(hql, Enquiry.class);
		query.setParameter("userId", userId);
		List<Enquiry> queries = query.getResultList();
		return queries;
	}



	@Override
	public void registerQuery(Enquiry query) {
		System.out.println("Adding Query : " + query.getQuery());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(query);
		session.getTransaction().commit();

	}

	@Override
	public void updateQuery(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Enquiry query= session.get(Enquiry.class, id);
		System.out.println("Updating Query : ");
		session.saveOrUpdate(query);
		session.getTransaction().commit();

	}

	@Override
	public void deleteQuery(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Enquiry query= session.get(Enquiry.class, id);
		System.out.println("Deleting Query : " +query.getEnquiryId());
		session.delete(query);
		session.getTransaction().commit();

	}



}
=======
package com.ems.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.model.Enquiry;

@Repository
public class EnquiryDAOImpl implements EnquiryDAO {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Enquiry> getQueries() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Enquiry.class);
		criteria.addOrder(Order.asc("enquiryId"));
		List<Enquiry> queries = criteria.list();
		return queries;
	}


	@Override
	public Enquiry getQueryById(int id) {
		Session session = sessionFactory.openSession();
		Enquiry enquiry =session.get(Enquiry.class, id);
		return enquiry;
	}

	@Override
	public List<Enquiry> getQueriesByUserId(int userId) {
		String hql = "SELECT e FROM " + Enquiry.class + " e WHERE e.id =:userId";

		Session session = sessionFactory.openSession();
		Query<Enquiry> query = session.createQuery(hql, Enquiry.class);
		query.setParameter("userId", userId);
		List<Enquiry> queries = query.getResultList();
		return queries;
	}



	@Override
	public void registerQuery(Enquiry query) {
		System.out.println("Adding Query : " + query.getQuery());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(query);
		session.getTransaction().commit();

	}

	@Override
	public void updateQuery(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Enquiry query= session.get(Enquiry.class, id);
		System.out.println("Updating Query : ");
		session.saveOrUpdate(query);
		session.getTransaction().commit();

	}

	@Override
	public void deleteQuery(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Enquiry query= session.get(Enquiry.class, id);
		System.out.println("Deleting Query : " +query.getEnquiryId());
		session.delete(query);
		session.getTransaction().commit();

	}



}
>>>>>>> ca98932d9306c6218e14d6b42efd1c68119703d8
