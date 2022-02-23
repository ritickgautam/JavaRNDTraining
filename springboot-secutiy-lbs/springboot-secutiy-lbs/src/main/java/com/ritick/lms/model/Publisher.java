package com.ritick.lms.model;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Publisher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int publisherId;
	private String publisherName;
	@OneToOne (cascade=CascadeType.ALL)
	private Book book;
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Publisher(String publisherName) {
		super();
		this.publisherName = publisherName;
	}
	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", publisherName=" + publisherName + ", book=" + book + "]";
	}



}
