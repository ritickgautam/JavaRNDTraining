package com.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.DAO.phoneBookDAO;
import com.DAO.phoneBookDAOImpl;
import com.Exception.DuplicateNameException;
import com.Exception.DuplicateNumberException;
import com.model.phoneBook;

public class PhonebookServiceImpl implements PhonebookService {
	static phoneBookDAO pbDAO = new phoneBookDAOImpl();
	static Scanner sc = new Scanner(System.in);

	@Override
	public void addphonebook() {
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Enter phone number: ");
		long number = Long.parseLong(sc.nextLine());
		
		phoneBook pb = new phoneBook();
		pb.setName(name);
		pb.setPhoneNumber(number);
		int check=0;
		try {
			check = pbDAO.ifExistEntry(pb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DuplicateNameException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (DuplicateNumberException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		if(check==1) {

			int flag = 0;
			try {
				flag= pbDAO.addphonebook(pb);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag>0) {
				System.out.println("Successfully Stored: ");
			}
			else
				if(flag==0) {
						System.out.println("Error in new phone Book Entry ");
					}
		}
		
	
		

	}

	@Override
	public void seachphonebookbyID() {
		System.out.println("Enter ID you want to search: ");
		int id= Integer.parseInt(sc.nextLine());
		try {
			phoneBook phoneBook = pbDAO.seachphonebookbyID(id);
			if(phoneBook!=null) 
			{
				System.out.println("Id: " + phoneBook.getId() + " Name: " + phoneBook.getName() + " Number: " + phoneBook.getPhoneNumber());
				}
			else 
			{
				System.out.println("PhoneBook does not contain this id");
			}
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void seachphonebookbyName() {
		System.out.println("Enter Name you want to search: ");
		String name= sc.nextLine();
		try {
			List<phoneBook> pbList = new ArrayList<>();
			pbList = pbDAO.seachphonebookbyName(name);
			if(pbList.isEmpty()) {
				System.out.println("PhoneBook does not contain this name");
			}
			else {	
				for (Iterator iterator = pbList.iterator(); iterator.hasNext();) {
				phoneBook phoneBook = (phoneBook) iterator.next();
				System.out.println("Id: " + phoneBook.getId() + " Name: " + phoneBook.getName() + " Number: " + phoneBook.getPhoneNumber());
				
			}
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void seachphonebookbyPhoneNumber() {
		System.out.println("Enter Number you want to search: ");
		Long number= Long.parseLong(sc.nextLine());
		try {
			List<phoneBook> pbList = new ArrayList<>();
			pbList = pbDAO.seachphonebookbyPhoneNumber(number);
			if(pbList.isEmpty()) {
				System.out.println("PhoneBook does not contain this number");
			}
			else {	
				for (Iterator iterator = pbList.iterator(); iterator.hasNext();) {
				phoneBook phoneBook = (phoneBook) iterator.next();
				System.out.println("Id: " + phoneBook.getId() + " Name: " + phoneBook.getName() + " Number: " + phoneBook.getPhoneNumber());
				
			}
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updatephonebook() {
		System.out.println("Enter the phoneBook id you want to update: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Updated Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Updated Number: ");
		Long num = Long.parseLong(sc.nextLine());
		
		phoneBook pb = new phoneBook();
		pb.setId(id);
		pb.setName(name);
		pb.setPhoneNumber(num);
		
		int flag = 0;
		try {
			flag=pbDAO.updatephonebook(pb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag>0) {
			System.out.println("Updated successfully");
		}
		else
			System.out.println("Entered wrong id");

	}

	@Override
	public void deletephonebook() {
		System.out.println("Enter the phoneBook id you want to delete: ");
		int id = Integer.parseInt(sc.nextLine());
		
		phoneBook pb = new phoneBook();
		pb.setId(id);
		
		int flag=0;
		try {
			flag = pbDAO.deletephonebook(pb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag>0) {
			System.out.println("Deleted Successfully");
		}
		else
			System.out.println("Invalid PhonebookID");
	}

	@Override
	public void getallphonebook() {
		List<phoneBook> pblist= new ArrayList<>();
		try {
			pblist = pbDAO.getallphonebook();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(pblist.isEmpty()) {
			System.out.println("PhoneBook does not contain any records ");
		}
		else
			for (Iterator iterator = pblist.iterator(); iterator.hasNext();) {
				phoneBook phoneBook = (phoneBook) iterator.next();
				System.out.println("Id: " + phoneBook.getId() + " Name: " + phoneBook.getName() + " Number: " + phoneBook.getPhoneNumber());
				
				
			}
	}

}
