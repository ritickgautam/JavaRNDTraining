package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Car;

@Repository
public class CarDAOImpl implements CarDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registerCar(Car car) {
		System.out.println("Adding car : " + car.getCarId());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(car);
		session.getTransaction().commit();

	}

	@Override
	public void updateCar(int carId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Car car = session.get(Car.class, carId);
		session.saveOrUpdate(car);
		session.getTransaction().commit();

	}

	@Override
	public void deleteCar(int carId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Car car = session.get(Car.class, carId);
		session.delete(car);
		session.getTransaction().commit();

	}

	@Override
	public Car getCarById(int carId) {
		Session session = sessionFactory.openSession();
		Car car =session.get(Car.class, carId);
		return car;
	}

	@Override
	public List<Car> getCars() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Car.class);
		criteria.addOrder(Order.asc("carId"));
		List<Car> cars = criteria.list();
		return cars;
	}

	@Override
	public List<Car> getCarsbyUserId(int userId) {
		String hql = "SELECT e FROM " + Car.class + " e WHERE e.userId =:userId";

		Session session = sessionFactory.openSession();
		Query<Car> query = session.createQuery(hql, Car.class);
		query.setParameter("userId", userId);
		List<Car> cars = query.getResultList();
		return cars;
	}

}
