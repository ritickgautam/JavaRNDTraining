<<<<<<< HEAD
package com.ems.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private long number;
	private int role; // 0->Admin 1->Student

	@JsonIgnore
	@OneToMany( mappedBy = "user",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Enquiry> queries;



	public List<Enquiry> getQueries() {
		return queries;
	}
	public void setQueries(List<Enquiry> queries) {
		this.queries = queries;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String email, String password, long number, int role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.number = number;
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", number="
				+ number + ", role=" + role + "]";
	}

	public void addQueries(Enquiry tempquery) {
		if(queries==null) {
			queries = new ArrayList<Enquiry>();
		}
		queries.add(tempquery);
		tempquery.setUser(this);
	}




}
=======
package com.ems.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private long number;
	private int role; // 0->Admin 1->Student

	@JsonIgnore
	@OneToMany( mappedBy = "user",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Enquiry> queries;



	public List<Enquiry> getQueries() {
		return queries;
	}
	public void setQueries(List<Enquiry> queries) {
		this.queries = queries;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String email, String password, long number, int role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.number = number;
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", number="
				+ number + ", role=" + role + "]";
	}

	public void addQueries(Enquiry tempquery) {
		if(queries==null) {
			queries = new ArrayList<Enquiry>();
		}
		queries.add(tempquery);
		tempquery.setUser(this);
	}




}
>>>>>>> ca98932d9306c6218e14d6b42efd1c68119703d8
