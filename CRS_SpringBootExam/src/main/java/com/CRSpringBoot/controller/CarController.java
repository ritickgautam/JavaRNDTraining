package com.CRSpringBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRSpringBoot.exception.NotFoundException;
import com.CRSpringBoot.model.Car;
import com.CRSpringBoot.service.CarService;

@RestController
@RequestMapping("crs/api/v1")
public class CarController {

	@Autowired
	private CarService cService;

	@GetMapping("/cars")
	private List<Car> getCars() {
		System.out.println("In car controller to check");
		return cService.getCars();
	}

	@GetMapping("/cars/{carId}")
	public Optional<Car> getCar(@PathVariable int carId){
		System.out.println("In car controller to check");
		Optional<Car> c = cService.getCarById(carId) ;
		if(c==null) {
			throw new NotFoundException("Car Id not found exception " + carId);
		}
		return c;

	}

	@PostMapping("/cars")
	public Car saveCar(@RequestBody Car car){
		System.out.println("In car controller to save car " + car.getCarId());
		car.setCarId(0);
		cService.registerCar(car);
		return car;

	}

	@PutMapping("/cars")
	public Car updateCar(@RequestBody Car car){
		System.out.println("In car controller to update car " + car.getCarId());
		cService.registerCar(car);
		return car;

	}
	@DeleteMapping("/cars/{carId}")
	public String deleteCar(@PathVariable int carId){
		Optional<Car> c = cService.getCarById(carId) ;
		if(c==null) {
			throw new NotFoundException("Car Id not found exception " + carId);
		}
		cService.deleteCar(carId);
		return "Car deleted successfully " + carId;

	}


}
