package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CarDAO;
import com.model.Car;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDAO dao;

	@Override
	public void registerCar(Car car) {
		dao.registerCar(car);

	}

	@Override
	public void updateCar(int carId) {
		dao.updateCar(carId);

	}

	@Override
	public void deleteCar(int carId) {
		dao.deleteCar(carId);

	}

	@Override
	public Car getCarById(int carId) {
		return dao.getCarById(carId);
	}

	@Override
	public List<Car> getCars() {
		return dao.getCars();
	}

	@Override
	public List<Car> getCarsbyUserId(int userId) {

		return dao.getCarsbyUserId(userId);
	}

}
