package com.CRSpringBoot.dao;

import org.springframework.data.repository.CrudRepository;

import com.CRSpringBoot.model.Car;

public interface CarDao extends CrudRepository<Car, Integer>{

}
