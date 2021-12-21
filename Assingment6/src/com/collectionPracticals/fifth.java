package com.collectionPracticals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class fifth {
	static Scanner sc = new Scanner(System.in);
	static Map<Integer, String> phoneBook = new HashMap<Integer, String>();

	public static void main(String[] args) throws InterruptedException {

		phoneBook.put(912123567, "Ritick");
		phoneBook.put(912123565, "Varun");
		phoneBook.put(912123516, "Kunal");
		phoneBook.put(912123557, "Atul");
		//boolean flag=true;
		while (true) {

			System.out.println("Enter the choice you want to select: "
					+ "\n1. New phonebook Entry"
					+ "\n2. Search Phonenumber "
					+ "\n3. Quit");
			
			int inp = Integer.parseInt(sc.nextLine());
			switch (inp) {
			case 1:
				newEntry(phoneBook);
				break;
			case 2:
				searchPhonenumber(phoneBook);
				break;
			case 3:
				System.out.println("thankyou");
//				flag=false;
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Selection ");
				break;
			}
	
		}
	}

	public static void newEntry(Map<Integer, String> phoneBook) {
		System.out.println("Enter Phone number: ");
		int phone_num= Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter Name: ");
		String name = sc.nextLine();
		phoneBook.put(phone_num, name);
		
		System.out.println("Updated PhoneBook List is: ");
		  for(Entry<Integer, String> m : phoneBook.entrySet()){    
			    System.out.println(m.getKey()+" "+m.getValue());    
			   }  
		
		
	}

	public static void searchPhonenumber(Map<Integer, String> phoneBook) {
		System.out.println("Enter the name you want to search ");
		String search_name = sc.nextLine();
		if(phoneBook.containsValue(search_name))
		{
			for (Entry<Integer, String> entry : phoneBook.entrySet()) {
	            if (entry.getValue().equals(search_name)) {
	                System.out.println("The phone number of "+ search_name + " is " + entry.getKey());
	            }
	        }
		}
		else
			System.out.println("you do not have any contact with this name: " + search_name);
	
		
	}

}
