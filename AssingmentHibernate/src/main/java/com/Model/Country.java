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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Country_ID")
	private int id;
	@Column(name = "Country_Name")
	private String name;

	@ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Language language;

	@OneToOne(cascade = CascadeType.ALL)
	private Capital capital;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
			name = "sport_country",
			joinColumns =  @JoinColumn(name = "Country_ID"),
			inverseJoinColumns = @JoinColumn(name =  "Sport_ID" )
			)
	private List<Sport> sports;

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
	public Capital getCapital() {
		return capital;
	}
	public void setCapital(Capital capital) {
		this.capital = capital;
	}

	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}

	public List<Sport> getSports() {
		return sports;
	}
	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void addSport(Sport tempSport) {
		if(sports==null) {
			sports = new ArrayList<Sport>();
		}
		sports.add(tempSport);
	}


}
