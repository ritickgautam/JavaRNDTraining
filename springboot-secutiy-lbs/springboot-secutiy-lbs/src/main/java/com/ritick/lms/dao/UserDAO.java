package com.ritick.lms.dao;

import org.springframework.data.repository.CrudRepository;

import com.ritick.lms.model.User;

public interface UserDAO extends CrudRepository<User, Integer>{

}
