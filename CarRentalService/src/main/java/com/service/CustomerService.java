package com.service;

import java.util.List;

import com.model.Customer;

public interface CustomerService {
	public void registerCustomer(Customer theCustomer);

	public Customer authenticate(String email, String password);

	public void updateCustomer(int id);

	public void deleteCustomer(int id);

	public Customer getCustomerById(int id);

	public List<Customer> getCustomers();

}
