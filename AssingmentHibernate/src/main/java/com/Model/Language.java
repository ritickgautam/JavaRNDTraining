package com.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Language_ID")
	private int id;
	@Column(name = "Language_Name")
	private String name;

	@OneToMany(mappedBy = "language" ,fetch = FetchType.EAGER , cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
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

	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Language(String name) {
		super();
		this.name = name;
	}
	public void addCountry(Country tempCountry) {
		if(countries==null) {
			countries = new ArrayList<Country>();
		}
		countries.add(tempCountry);
		tempCountry.setLanguage(this);
	}

}
