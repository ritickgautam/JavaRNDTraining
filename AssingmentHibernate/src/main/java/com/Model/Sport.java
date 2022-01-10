package com.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Sport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Sport_ID")
	private int id;
	@Column(name = "Sport_Name")
	private String name;

	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
			name = "sport_country",
			joinColumns =  @JoinColumn(name = "Sport_ID"),
			inverseJoinColumns = @JoinColumn(name =  "Country_ID" )
			)
	private List<Country> countries;

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
	public Sport(String name) {
		super();
		this.name = name;
	}

	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	public Sport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addCountry(Country tempCountry) {
		if(countries==null) {
			countries = new ArrayList<Country>();
		}
		countries.add(tempCountry);
	}


}
