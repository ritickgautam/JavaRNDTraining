package com.stringFunction;

import java.util.Scanner;

public class third {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter First String ");
	String str1 = sc.nextLine();
	System.out.println("Enter First String ");
	String str2 = sc.nextLine();
	
	third obj= new third();
	String str= obj.minCat(str1,str2);
	System.out.println("The concatenated string " + str);
	sc.close();
}

private String minCat(String a, String b) {
	if (a.length() == b.length())
	    return a+b;
	if (a.length() > b.length()){
		 int diff = a.length() - b.length();
		 return a.substring(diff, a.length()) + b;
	}
	else
	{
		int diff = b.length()-a.length();
		return a + b.substring(diff, b.length());
		
	}
	


	
}

}
