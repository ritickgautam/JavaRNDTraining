package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Car;
import com.model.Customer;
import com.service.CarService;

@Controller
@RequestMapping("car")
public class CarController {

	@Autowired
	private CarService cService;

	@RequestMapping(method = RequestMethod.GET, value = "listCar")
	private String getCars(@ModelAttribute("customer")Customer customer,Model model) {
		List<Car> cars = cService.getCars();

		model.addAttribute("customer", customer);
		model.addAttribute("cars", cars);
		return "list-cars-user";
	}

	@GetMapping("addCar")
	public String addCarForm(Model model) {
		model.addAttribute("car", new Car());

		return "add-car-form";
	}

	@PostMapping("saveCar")
	public String saveCar(Model model,@ModelAttribute("car")Car car) {

		Customer c = (Customer) model.getAttribute("customer");
		car.setCustomer(c);
		cService.registerCar(car);
		model.addAttribute("message", "Car Saved Successfully");
		return "redirect:/car/listCar";
	}

	@GetMapping("showUpdatedForm")
	public String showUpdatedForm(Model model, @RequestParam("carId") int carId) {
		System.out.println("Update carId: "+carId);
		Car car = cService.getCarById(carId);
		model.addAttribute("car", car);
		System.out.println("updated...");
		return "add-car-form";
	}

	@GetMapping("delete")
	public String deleteCar(@RequestParam("carId") int carId) {
		cService.deleteCar(carId);
		return "redirect:/car/listCar";
	}




}
