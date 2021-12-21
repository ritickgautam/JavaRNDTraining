package com.collectionPracticals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class phoneBook {

	static Scanner sc = new Scanner(System.in);
	static Map<String, Integer> phoneBook = new HashMap<String, Integer>();

	public static void main(String[] args) throws InterruptedException {

		
		phoneBook.put("Ritick",912123567);
		phoneBook.put("Varun",912123565);
		phoneBook.put("Kunal",912123516);
		phoneBook.put("Atul",912123557);

		
		//boolean flag = true;
		while (true) {
			System.out.println("Enter the choice you want to select: " + "\n1. New phonebook Entry" + "\n2. Search Pho"
					+ "nenumber " + "\n3. Quit");
			int inp = Integer.parseInt(sc.nextLine());

			switch (inp) {
			case 1:
				newEntry();
				break;
			case 2:
				searchPhonenumber();
				break;
			case 3:
				System.exit(0);
			}

		}
	}

	public static void newEntry() {
		System.out.println("Enter Phone number: ");
		int phone_num = Integer.parseInt(sc.nextLine());

		System.out.println("Enter Name: ");
		String name = sc.nextLine();
		phoneBook.put(name,phone_num);

		System.out.println("Updated PhoneBook List is: ");
		for (Entry<String, Integer> m : phoneBook.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

	}

	public static void searchPhonenumber() {
		System.out.println("Enter the name you want to search ");
        int phoneNumber;
		String search_name = sc.nextLine();
//		if (phoneBook.containsValue(search_name)) {
//			for (Entry<Integer, String> entry : phoneBook.entrySet()) {
//				if (entry.getValue().equals(search_name)) {
//					System.out.println("The phone number of " + search_name + " is " + entry.getKey());
//				}
//				break;
//			}
//		} else {
//			System.out.println("you do not have any contact with this name: " + search_name);
//		}
		phoneNumber = phoneBook.get(search_name);  
		System.out.println("The phone number of " + search_name + " is " + phoneNumber);
	}
}