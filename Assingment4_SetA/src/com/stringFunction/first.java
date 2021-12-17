package com.stringFunction;

import java.util.Scanner;

public class first {
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = sc.nextLine();

		delDel(str);	
		sc.close();
	}
	
	public static void delDel(String str) {
//		char ch[]= {};
//		str.getChars(1, 4, ch, 0);
		int x= str.indexOf("del");
		
		if(x==1)
		{
			System.out.println(str.substring(0,1) + str.substring(4));  
		}
		else
			System.out.println(str);
	}
}
