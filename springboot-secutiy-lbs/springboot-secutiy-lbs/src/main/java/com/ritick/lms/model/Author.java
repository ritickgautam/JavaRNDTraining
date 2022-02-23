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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int authorId;
	private String authorName;
	@OneToOne (cascade=CascadeType.ALL)
	private Book book;
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(String authorName) {
		super();
		this.authorName = authorName;
	}
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", book=" + book + "]";
	}



}
