package com.ritick.pms.controller;

import java.util.Scanner;

import com.ritick.pms.service.phoneBookService;
import com.ritick.pms.service.phoneBookServiceImpl;

public class phoneBookMgmt {
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
					phoneBookService pb = new phoneBookServiceImpl();
					switch (choice) {
					case 1: {
						pb.addPhonebook();
						break;
					}
					case 2: {
						System.out.println("Press 1 for search by Id: ");
						System.out.println("Press 2 for search by Number: ");
						System.out.println("Press 3 for search by Name: ");
						System.out.println("Press 4 for search by DOB: ");
						choice = Integer.parseInt(sc.nextLine());
						if(choice==1) {
							pb.findPhoneBookbyId();
						}
						else
							if(choice==2) {
								pb.findPhoneBookbyNumber();
							}
							else
								if(choice==3) {
									pb.findPhoneBookbyName();
								}
								else
									if(choice==4) {
										pb.findPhoneBookbyDOB();
									}
									else
										System.out.println("Sorry invalid selection");
						break;
					}
					case 3: {
						pb.updatePhoneBook();
						break;
					}
					case 4: {
						pb.deletePhoneBook();
						break;
					}
					case 5: {
						pb.showPhoneBooks();
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
				System.out.println(e);
				System.out.println("Invalid Input! Run Again");
			}
		}
	}


