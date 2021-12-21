package com.collectionPracticals;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

class name{
	private String firstName;
	private String secondName;
	public name(String firstName, String secondName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
	}
	@Override
	public String toString() {
		return firstName + " " + secondName;
	}
	
}

public class fourth {
	static Scanner sc =new Scanner(System.in);
	
	public static void main(String[] args) {
		List<name> Name = new Vector<name>();
		
		Name.add(new name("Ritick", "Gautam"));
		Name.add(new name("Atul", "Kumar"));
		Name.add(new name("Saurabh", "Singh"));
		Name.add(new name("Kunal", "Rawat"));
		boolean flag = true;
		while (flag) {

			System.out.println("Enter the choice you want to select"
					+ "\nA for Enter First Name and Last name"
					+ "\nB for View all the names"
					+ "\nC for Quit");
			String inp = sc.nextLine();
			switch (inp) {
			case "A":
				String firstName = args[0];
				String lastName = args[1];
				Name=(addName(Name,firstName,lastName));
				System.out.println("Added Successfully");
				System.out.println();
				System.out.println("Updated Name details ");
				Enumeration e=Collections.enumeration(Name);
				while(e.hasMoreElements())
				       System.out.println(e.nextElement());
				
				break;
			case "B":
				display(Name);
				break;
			case "C":
				System.out.println("thankyou");
				flag=false;
				break;
			default:
				System.out.println("Invalid Selection ");
			}
			
		}
	}

	public static void display(List<name> name) {
		Enumeration e=Collections.enumeration(name);
		System.out.println("Name details ");
		
		while(e.hasMoreElements())
		       System.out.println(e.nextElement());
		
	}

	public static List<name> addName(List<name> name, String firstName, String lastName) {		
		name.add(new name(firstName, lastName));
		return name;
		
	}

}
