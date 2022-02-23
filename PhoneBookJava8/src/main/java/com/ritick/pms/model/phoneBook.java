package com.ritick.pms.model;

import java.time.LocalDate;

public class phoneBook {
	private int id;
	private long phoneNumber;
	private String name;
	private LocalDate date;



	@Override
	public String toString() {
		return "phoneBook [id=" + id + ", phoneNumber=" + phoneNumber + ", name=" + name + ", date=" + date + "]";
	}
	public phoneBook(int id, long phoneNumber, String name, LocalDate date) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.date = date;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public phoneBook() {
		super();
		// TODO Auto-generated constructor stub
	}



}
