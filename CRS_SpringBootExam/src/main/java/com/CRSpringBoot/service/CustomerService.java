package com.CRSpringBoot.service;

import java.util.List;
import java.util.Optional;

import com.CRSpringBoot.model.Customer;

public interface CustomerService {
	public void registerCustomer(Customer theCustomer);

	public Customer authenticate(String email, String password);

	public void deleteCustomer(int id);

	public Optional<Customer> getCustomerById(int id);

	public List<Customer> getCustomers();

}
