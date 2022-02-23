package com.dao;

import java.util.List;

import com.model.Car;

public interface CarDAO {

	public void registerCar(Car car);

	public void updateCar(int carId);

	public void deleteCar(int carId);

	public Car getCarById(int carId);

	public List<Car> getCars();

	public List<Car> getCarsbyUserId(int userId);

}
