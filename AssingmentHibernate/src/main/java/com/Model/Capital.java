package com.Model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Capital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "City_ID")
	private int id;
	@Column(name = "City_Name")
	private String name;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Capital(String name) {
		super();
		this.name = name;
	}
	public Capital() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Capital [id=" + id + ", name=" + name + "]";
	}




}
