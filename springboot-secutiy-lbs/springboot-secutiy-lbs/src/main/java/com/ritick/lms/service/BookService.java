package com.ritick.lms.service;

import java.util.List;
import java.util.Optional;

import com.ritick.lms.model.Book;

public interface BookService {
	public void registerBookDetails(Book book);
	public void updateBookDetails(Book book);
	public void deleteBookDetails(int id);
	public List<Book> getBookDetails();
	public Optional<Book> getBookDetailsById(int id);
}
