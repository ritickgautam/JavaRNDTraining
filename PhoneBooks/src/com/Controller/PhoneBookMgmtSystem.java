package com.Controller;

import java.util.Scanner;

import com.Service.PhonebookService;
import com.Service.PhonebookServiceImpl;

public class PhoneBookMgmtSystem {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			int choice=0;
			boolean flag=true;
			while(flag) {
				System.out.println("====================");
				System.out.println("Welcome to PhoneBook ");
				System.out.println("====================");
				System.out.println("Press 1 for New PhoneBook Entry: ");
				System.out.println("Press 2 for Search PhoneBook: ");
				System.out.println("Press 3 for Update PhoneBook: ");
				System.out.println("Press 4 for Delete PhoneBook: ");
				System.out.println("Press 5 for see all PhoneBook records: ");
				System.out.println("Press 6 for Quit: ");
				choice = Integer.parseInt(sc.nextLine());
				PhonebookService pb = new PhonebookServiceImpl();
				switch (choice) {
				case 1: {
					pb.addphonebook();
					break;
				}
				case 2: {
					System.out.println("Press 1 for search by Id: ");
					System.out.println("Press 2 for search by Number: ");
					System.out.println("Press 3 for search by Name: ");
					choice = Integer.parseInt(sc.nextLine());
					if(choice==1) {
						pb.seachphonebookbyID();
					}
					else
						if(choice==2) {
							pb.seachphonebookbyPhoneNumber();
						}
						else
							if(choice==3) {
								pb.seachphonebookbyName();
							}
							else
								System.out.println("Sorry invalid selection");
					break;
				}
				case 3: {
					pb.updatephonebook();
					break;
				}
				case 4: {
					pb.deletephonebook();
					break;
				}
				case 5: {
					pb.getallphonebook();
					break;
				}
				case 6: {
					flag=false;
					System.out.println("Okay bye!");
					System.exit(0);
					break;
				}
				default:
					System.out.println("Press 1-6");
				}

			}
			
		} catch (Exception e) {
			System.out.println("Invalid Input! Run Again");
		}
	}
}
