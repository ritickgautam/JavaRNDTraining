package com.CRSpringBoot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRSpringBoot.dao.CustomerDao;
import com.CRSpringBoot.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao dao;

	@Transactional
	@Override
	public void registerCustomer(Customer theCustomer) {
		dao.save(theCustomer);

	}

	@Override
	public Customer authenticate(String email, String password) {
		List<Customer> customers = (List<Customer>) dao.findAll();
		for (Customer customer : customers) {
			if(customer.getEmail().equals(email) && customer.getPassword().equals(password))
			{
				return customer;
			}
		}
		return null;
	}

	@Transactional
	@Override
	public void deleteCustomer(int id) {
		dao.deleteById(id);

	}

	@Override
	public Optional<Customer> getCustomerById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return (List<Customer>) dao.findAll();
	}



}
