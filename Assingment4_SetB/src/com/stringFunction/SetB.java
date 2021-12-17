package com.stringFunction;

public class SetB {
	public static void main(String[] args) {
		System.out.println("Practical 1");
		stringBits("hello");
		stringBits("Hi");
		stringBits("Heeololeo");
		
		System.out.println("================");
		System.out.println("Practical 2");
		
		missingChar("Kitten",1);
		missingChar("kitten", 0);
		missingChar("kitten", 4);
		missingChar("kitten", 8);
		
		System.out.println("================");
		System.out.println("Practical 3");
		
		altPairs("kitten");
		altPairs("Chocolate");
		altPairs("CodingHorror");
		
	}
	public static void stringBits(String str) {
		
		String temp = "";
		for (int i = 0; i < str.length(); i = i + 2) {
			temp += str.charAt(i);
		}

		System.out.println("The new string " + temp);

	}

public static void missingChar(String str, int n) {
	
	if(n<=str.length()-1)
	System.out.println(str.substring(0,n) + str.substring(n+1,str.length()));	
	else
		System.out.println("Invalid integer size");
}

	public static void altPairs(String str) {
		String res = "";
		for (int i=0; i<str.length(); i += 4) {
			int end = i + 2;
			if (end > str.length()) {
				end = str.length();
			}
			res = res + str.substring(i, end);

		}

		System.out.println("The Alternate string is "+res);

	}
}
