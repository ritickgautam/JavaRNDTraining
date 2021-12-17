package com.car;

public class Car {
	public int speed;
	public String carType;
	public String carOwner;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(int speed, String carType, String carOwner) {
		super();
		this.speed = speed;
		this.carType = carType;
		this.carOwner = carOwner;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarOwner() {
		return carOwner;
	}
	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}
	
}
