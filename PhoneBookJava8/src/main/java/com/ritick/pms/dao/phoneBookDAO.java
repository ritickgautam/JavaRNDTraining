package com.ritick.pms.dao;

import java.time.LocalDate;

import com.ritick.pms.exception.DuplicateNameException;
import com.ritick.pms.exception.DuplicateNumberException;
import com.ritick.pms.model.phoneBook;

public interface phoneBookDAO {
	public void addPhonebook(phoneBook pb) throws DuplicateNameException, DuplicateNumberException;

	public phoneBook findPhoneBookbyId(int id);
	public phoneBook findPhoneBookbyName(String name);
	public phoneBook findPhoneBookbyNumber(long number);
	public phoneBook findPhoneBookbyDOB(LocalDate date);

	public void updatePhoneBook(phoneBook pb);

	public void deletePhoneBook(int id);

	public void showPhoneBooks();



}
