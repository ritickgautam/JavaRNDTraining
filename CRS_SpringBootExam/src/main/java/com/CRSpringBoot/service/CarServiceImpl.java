package com.CRSpringBoot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRSpringBoot.dao.CarDao;
import com.CRSpringBoot.model.Car;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarDao dao;

	@Transactional
	@Override
	public void registerCar(Car car) {
		dao.save(car);
	}

	@Transactional
	@Override
	public void deleteCar(int carId) {
		dao.deleteById(carId);

	}

	@Override
	public Optional<Car> getCarById(int carId) {
		// TODO Auto-generated method stub
		return dao.findById(carId);
	}

	@Override
	public List<Car> getCars() {
		// TODO Auto-generated method stub
		return (List<Car>) dao.findAll();
	}

	@Override
	public List<Car> getCarsbyUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
