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
import com.CRSpringBoot.model.Customer;
import com.CRSpringBoot.service.CustomerService;

@RestController
@RequestMapping("crs/api/v1")
public class CustomerController {

	@Autowired
	private CustomerService cService;

	@GetMapping("/customers")
	private List<Customer> getCustomers() {
		System.out.println("In customer controller to get list of cars");
		return cService.getCustomers();
	}

	@GetMapping("/customers/{userId}")
	public Optional<Customer> getCustomer(@PathVariable int userId){
		System.out.println("In customer controller to get car");
		Optional<Customer> c = cService.getCustomerById(userId) ;
		if(c==null) {
			throw new NotFoundException("Customer Id not found exception " + userId);
		}
		return c ;

	}

	@PostMapping("/cars")
	public Customer saveCar(@RequestBody Customer customer){
		System.out.println("In customer controller to save customer " + customer.getName());
		customer.setUserId(0);
		cService.registerCustomer(customer);
		return customer;

	}

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer){
		System.out.println("In customer controller to update customer " + customer.getUserId());
		cService.registerCustomer(customer);
		return customer;

	}
	@DeleteMapping("/customers/{userId}")
	public String deleteCustomer(@PathVariable int userId){
		Optional<Customer> c = cService.getCustomerById(userId) ;
		if(c==null) {
			throw new NotFoundException("Customer Id not found exception " + userId);
		}
		cService.deleteCustomer(userId);
		return "Customer deleted successfully " + userId;

	}

	@PostMapping("/authenticate")
	public String authenticate(@RequestBody Customer customer) {
		String email = customer.getEmail();
		String password = customer.getPassword();
		Customer temp= cService.authenticate(email, password);
		if(temp!=null) {
			return "Login successfully as " + temp.getName();
		}
		else
		{
			return "Login failed";

		}
	}
}
