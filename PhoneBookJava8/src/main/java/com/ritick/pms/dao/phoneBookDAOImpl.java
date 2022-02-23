package com.ritick.pms.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ritick.pms.exception.DuplicateNameException;
import com.ritick.pms.exception.DuplicateNumberException;
import com.ritick.pms.model.phoneBook;

public class phoneBookDAOImpl implements phoneBookDAO {

    static List<phoneBook> pbList = new ArrayList<>();

	@Override
	public void addPhonebook(phoneBook pb) throws DuplicateNameException, DuplicateNumberException {
		if(pbList.stream().filter(p-> p.getName().equals(pb.getName())).findAny().orElse(null)==null)
		{
			pbList.add(pb);
		}
		else
		{
			System.out.println("Duplicate name exist!!");
			throw new DuplicateNameException("Duplicate name found");
		}
		if(pbList.stream().filter(p-> p.getPhoneNumber()==pb.getPhoneNumber()).findAny().orElse(null)==null)
		{
			pbList.add(pb);
		}
		else
		{
			System.out.println("Duplicate number exist!!");
			throw new DuplicateNumberException("Duplicate number found");
		}

	}

	@Override
	public phoneBook findPhoneBookbyId(int id) {
		phoneBook pb = pbList.stream().filter(p -> id==p.getId()).findAny().orElse(null);

		return pb;
	}

	@Override
	public phoneBook findPhoneBookbyName(String name) {
		phoneBook pb = pbList.stream().filter(p -> name.equals(p.getName())).findAny().orElse(null);
		return pb;
	}

	@Override
	public phoneBook findPhoneBookbyNumber(long number) {
		phoneBook pb = pbList.stream().filter(p -> number==p.getPhoneNumber()).findAny().orElse(null);
		return pb;
		}

	@Override
	public phoneBook findPhoneBookbyDOB(LocalDate date) {
		phoneBook pb = pbList.stream().filter(p -> date==p.getDate()).findAny().orElse(null);
		return pb;
	}

	@Override
	public void updatePhoneBook(phoneBook pb) {
		int id = pb.getId();
		//for removing the phonebook having id - pb.getId()
		pbList = pbList.stream().filter(i->i.getId()!=id).collect(Collectors.toList());
		pbList.add(pb);

	}

	@Override
	public void deletePhoneBook(int id) {
		//for removing the phonebook having id - pb.getId()
		pbList = pbList.stream().filter(i->i.getId()!=id).collect(Collectors.toList());
	}

	@Override
	public void showPhoneBooks() {
		pbList.stream().forEach(System.out::println);

	}

}
