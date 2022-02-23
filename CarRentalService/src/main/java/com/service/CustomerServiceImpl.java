package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustormerDAO;
import com.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustormerDAO dao;

	@Override
	@Transactional
	public void registerCustomer(Customer theCustomer) {
		dao.registerCustomer(theCustomer);

	}

	@Override
	public void updateCustomer(int id) {
		dao.updateCustomer(id);

	}

	@Override
	public void deleteCustomer(int id) {
		dao.deleteCustomer(id);

	}

	@Override
	public Customer getCustomerById(int id) {
		return dao.getCustomerById(id);
	}


	@Override
	public List<Customer> getCustomers() {

		return dao.getCustomers();
	}

	@Override
	public Customer authenticate(String email, String password) {

		return dao.authenticate(email, password);
	}

}
