package com.ems.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Enquiry {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int enquiryId;
	private String query;
	private Date date;

	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private User user;

	public int getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Enquiry(int enquiryId, String query, Date date, User user) {
		super();
		this.enquiryId = enquiryId;
		this.query = query;
		this.date = date;
		this.user = user;
	}

	public Enquiry() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Enquiry [enquiryId=" + enquiryId + ", query=" + query + ", date=" + date + ", user=" + user + "]";
	}



}
