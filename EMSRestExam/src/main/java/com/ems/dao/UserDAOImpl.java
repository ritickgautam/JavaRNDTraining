package com.ems.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.addOrder(Order.asc("id"));
		List<User> users = criteria.list();
		return users;
	}

	@Override
	public void registerUser(User user) {
		System.out.println("Adding User : " + user.getName());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();

	}


	@Override
	public void updateUser(int id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = session.get(User.class, id);
		System.out.println("Updating User : ");
		session.saveOrUpdate(user);
		session.getTransaction().commit();


	}

	@Override
	public void deleteUser(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = session.get(User.class, id);
		System.out.println("Deleting User : " + user.getName());
		session.delete(user);
		session.getTransaction().commit();

	}

	@Override
	public User getUserById(int id) {
		Session session = sessionFactory.openSession();
		User user =session.get(User.class, id);
		return user;
	}


	@Override
	public User authenticate(String email, String password) {
		System.out.println("Check for user authentication: " + email + " " + password);
		User user = null;

		try {
			String hql = "SELECT e FROM " + User.class.getName() + " e WHERE e.email =:email AND e.password =:password";

			Session session = sessionFactory.openSession();
			Query<User> query = session.createQuery(hql, User.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			user = query.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("Login Failed");
			return null;
		}
		System.out.println("Login successfully as "+ user.getName());
		return user;

	}

	@Override
	public User getUserByName(String name) {
		System.out.println("Getting user by name: " + name);
		User user = null;
		String hql = "SELECT e FROM " + User.class.getName() + " e WHERE e.name =:name";

		Session session = sessionFactory.openSession();
		Query<User> query = session.createQuery(hql, User.class);
		query.setParameter("name", name);
		user = query.getSingleResult();
		return user;
	}

}
