package com.CRSpringBoot.dao;

import org.springframework.data.repository.CrudRepository;

import com.CRSpringBoot.model.Customer;

public interface CustomerDao extends CrudRepository<Customer, Integer>{

}
