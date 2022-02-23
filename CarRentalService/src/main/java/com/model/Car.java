package com.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int carId;
	private String carType; //SUV, XUV, Sedan, MUV
	private int status=0; //0->not booked 1->booked

	@ManyToOne
	private Customer customer;

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



}
