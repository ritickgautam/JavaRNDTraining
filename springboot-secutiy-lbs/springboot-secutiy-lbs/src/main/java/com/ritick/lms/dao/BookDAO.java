package com.ritick.lms.dao;

import org.springframework.data.repository.CrudRepository;

import com.ritick.lms.model.Book;

public interface BookDAO extends CrudRepository<Book, Integer>{

}
