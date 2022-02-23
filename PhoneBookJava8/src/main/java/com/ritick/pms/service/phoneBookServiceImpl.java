package com.ritick.pms.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ritick.pms.dao.phoneBookDAO;
import com.ritick.pms.dao.phoneBookDAOImpl;
import com.ritick.pms.exception.DuplicateNameException;
import com.ritick.pms.exception.DuplicateNumberException;
import com.ritick.pms.model.phoneBook;

public class phoneBookServiceImpl implements phoneBookService{

	phoneBookDAO dao = new phoneBookDAOImpl();
	static Scanner sc = new Scanner(System.in);

	static int id = 0;

	@Override
	public void addPhonebook() {
		id = id+1;
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Enter phone number: ");
		long number = Long.parseLong(sc.nextLine());
		System.out.println("Enter DOB: ");
		LocalDate date = LocalDate.parse(sc.nextLine());

		phoneBook pb = new phoneBook();
		pb.setId(id);
		pb.setName(name);
		pb.setPhoneNumber(number);
		pb.setDate(date);

		try {
			dao.addPhonebook(pb);
			System.out.println("Successfully Stored: ");
		} catch (DuplicateNameException | DuplicateNumberException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}


	}

	@Override
	public void findPhoneBookbyId() {
		System.out.println("Enter ID you want to search: ");
		int id= Integer.parseInt(sc.nextLine());
		phoneBook phoneBook = dao.findPhoneBookbyId(id);
		if(phoneBook!=null)
		{
			System.out.println("Id: " + phoneBook.getId() + " Name: " + phoneBook.getName() + " Number: " + phoneBook.getPhoneNumber() + " DOB: " + phoneBook.getDate() );
			}
		else
		{
			System.out.println("PhoneBook does not contain this id");
		}
	}

	@Override
	public void findPhoneBookbyName() {
		System.out.println("Enter Name you want to search: ");
		String name= sc.nextLine();
		phoneBook phoneBook = dao.findPhoneBookbyName(name);
		if(phoneBook!=null)
		{
			System.out.println("Id: " + phoneBook.getId() + " Name: " + phoneBook.getName() + " Number: " + phoneBook.getPhoneNumber() + " DOB: " + phoneBook.getDate() );
			}
		else
		{
			System.out.println("PhoneBook does not contain this name");
		}

	}

	@Override
	public void findPhoneBookbyNumber() {
		System.out.println("Enter number you want to search: ");
		long number= Long.parseLong(sc.nextLine());
		phoneBook phoneBook = dao.findPhoneBookbyNumber(number);
		if(phoneBook!=null)
		{
			System.out.println("Id: " + phoneBook.getId() + " Name: " + phoneBook.getName() + " Number: " + phoneBook.getPhoneNumber() + " DOB: " + phoneBook.getDate() );
			}
		else
		{
			System.out.println("PhoneBook does not contain this id");
		}
	}

	@Override
	public void findPhoneBookbyDOB() {
		System.out.println("Enter DOB you want to search: ");
		LocalDate date= LocalDate.parse(sc.nextLine()) ;
		phoneBook phoneBook = dao.findPhoneBookbyDOB(date);
		if(phoneBook!=null)
		{
			System.out.println("Id: " + phoneBook.getId() + " Name: " + phoneBook.getName() + " Number: " + phoneBook.getPhoneNumber() + " DOB: " + phoneBook.getDate() );
			}
		else
		{
			System.out.println("PhoneBook does not contain this id");
		}
	}

	@Override
	public void updatePhoneBook() {
		System.out.println("Enter id you want to update: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Enter updated name: ");
		String name = sc.nextLine();
		System.out.println("Enter updated phone number: ");
		long number = Long.parseLong(sc.nextLine());
		System.out.println("Enter updated DOB: ");
		LocalDate date = LocalDate.parse(sc.nextLine());

		phoneBook pb = new phoneBook();
		pb.setId(id);
		pb.setName(name);
		pb.setPhoneNumber(number);
		pb.setDate(date);

		dao.updatePhoneBook(pb);
		System.out.println("Phonebook updated");
		System.out.println(pb);
	}

	@Override
	public void deletePhoneBook() {

		JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("data/login.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray userList = (JSONArray) obj;

            System.out.println("For deleting a contact you need to be admin"
            		+ "\nPlease enter you admin id and password");
            System.out.println("Enter admin username: ");
            String username = sc.nextLine();
            System.out.println("Enter admin password: ");
            String password = sc.nextLine();



            //check for id password and role = admin
            if(userList.stream().filter(object -> ((JSONObject) object).get("loginName").equals(username) && ((JSONObject) object).get("password").equals(password) && ((JSONObject) object).get("role").equals("admin")).findAny().orElse(null)!=null)
            {
            	System.out.println("=============================");
            	System.out.println("Admin Panel");
            	System.out.println("=============================");
            	System.out.println("Enter id you want to deleted : ");
            	int id = Integer.parseInt(sc.nextLine());
            	dao.deletePhoneBook(id);
            	System.out.println("Deleted Successfully");

            }
            else
            	System.out.println("Invalid credentials!!!");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

 	}

	@Override
	public void showPhoneBooks() {
		dao.showPhoneBooks();
	}



}
