package com.ritick.lms.model;

import java.sql.Date;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookId;
	private String title;
	private Date year;
	private String isbn;
	private int availableBooks;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getAvailableBooks() {
		return availableBooks;
	}
	public void setAvailableBooks(int availableBooks) {
		this.availableBooks = availableBooks;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String title, Date year, String isbn, int availableBooks) {
		super();
		this.title = title;
		this.year = year;
		this.isbn = isbn;
		this.availableBooks = availableBooks;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", year=" + year + ", isbn=" + isbn + ", availableBooks="
				+ availableBooks + "]";
	}







}
