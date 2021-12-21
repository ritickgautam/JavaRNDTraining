package com.collectionPracticals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class first {
public static void main(String[] args) {
	List<String> names = new ArrayList<String>();
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of student ");
	int num=sc.nextInt();
	for (int i = 0; i < num; i++) {
		System.out.println("Enter the name of "+ (i+1) +" Student");
		names.add(sc.next());
		
	}
	System.out.println("List of student names :" + names);
	System.out.println("Enter the name of student you want to search :");

	String stud = sc.next();
		if(names.contains(stud))
			System.out.println("Student " + stud + " is in the class");
		else
			System.out.println("Student " + stud + " is not in the class");
	sc.close();
	}
}
