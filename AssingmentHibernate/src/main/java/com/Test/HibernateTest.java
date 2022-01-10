package com.Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Model.Capital;
import com.Model.Country;
import com.Model.Language;
import com.Model.Sport;

public class HibernateTest {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("com/resources/hibernate.cfg.xml")
				.addAnnotatedClass(Country.class)
				.addAnnotatedClass(Capital.class)
				.addAnnotatedClass(Language.class)
				.addAnnotatedClass(Sport.class)
				.buildSessionFactory();

		Session session = sf.openSession();
		session.beginTransaction();

		try {

			session.getTransaction().commit();
			System.out.println("Done");

		}
		finally {
			session.close();
			sf.close();
		}
	}

}
