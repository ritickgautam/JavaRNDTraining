package com.CRSpringBoot.service;

import java.util.List;
import java.util.Optional;

import com.CRSpringBoot.model.Car;

public interface CarService {

	public void registerCar(Car car);

	public void deleteCar(int carId);

	public Optional<Car> getCarById(int carId);

	public List<Car> getCars();

	public List<Car> getCarsbyUserId(int userId);
}
