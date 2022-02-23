package com.ritick.lms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritick.lms.dao.BookDAO;
import com.ritick.lms.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO dao;

	@Override
	@Transactional
	public void registerBookDetails(Book book) {
		dao.save(book);
	}

	@Override
	@Transactional
	public void updateBookDetails(Book book) {
		dao.save(book);
	}

	@Override
	@Transactional
	public void deleteBookDetails(int id) {
		dao.deleteById(id);;
	}

	@Override
	public List<Book> getBookDetails() {
		return (List<Book>) dao.findAll();
	}

	@Override
	public Optional<Book> getBookDetailsById(int id) {
		return dao.findById(id);
	}

}
