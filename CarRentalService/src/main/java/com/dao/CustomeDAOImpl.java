package com.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Customer;

@Repository
public class CustomeDAOImpl implements CustormerDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registerCustomer(Customer theCustomer) {
		System.out.println("Adding customer : " + theCustomer.getName());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(theCustomer);
		session.getTransaction().commit();
		// TODO Auto-generated method stub

	}


	@Override
	public Customer authenticate(String email, String password) {
		System.out.println("Check for existing user: " + email + " " + password);
		Customer user = null;

		try {
			String hql = "SELECT e FROM " + Customer.class.getName() + " e WHERE e.email =:email AND e.password =:password";

			Session session = sessionFactory.openSession();
			Query<Customer> query = session.createQuery(hql, Customer.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			user = query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}

		return user;

	}

	@Override
	public void updateCustomer(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.saveOrUpdate(customer);
		session.getTransaction().commit();

	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		session.getTransaction().commit();

	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.openSession();
		Customer customer =session.get(Customer.class, id);
		return customer;
	}


	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.addOrder(Order.asc("userId"));
		List<Customer> customers = criteria.list();
		return customers;
	}


}
