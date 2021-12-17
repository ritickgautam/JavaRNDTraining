package com.stringFunction;

import java.util.Scanner;

public class Second {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = sc.nextLine();
		middleThree(str);
		sc.close();
	}

	public static void middleThree(String str) {
		int len = str.length()/2;
		System.out.println(str.substring(len-1,len+2));
	}


}
