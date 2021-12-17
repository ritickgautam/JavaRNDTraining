package com.stringFunction;

public class SetC {
	public static void main(String[] args) {
		
		System.out.println("First Practical");
		System.out.println(stringE("hello"));
		System.out.println(stringE("Heelle"));
		System.out.println(stringE("Heelele"));
		
		System.out.println("==============");
		System.out.println("Practical 2");
		
		backAround("cat");
		backAround("Hello");
		backAround("a");
		

		System.out.println("==============");
		System.out.println("Practical 3");
		

		countXX("abcxx");
		countXX("xxx");
		countXX("xxxx");
		
		
		}
	public static void countXX(String str) {
		  int count = 0;
		  for (int i = 0; i < str.length()-1; i++) {
		    if (str.substring(i, i+2).equals("xx")) count++;
		  }
		  System.out.println(count);
		
	}
	public static void backAround(String str) {
		  char temp = str.charAt(str.length() - 1);
		  System.out.println(temp + str + temp);
	}
		
		
	public static boolean stringE(String str) {
		int len = str.length();
		int counter = 0;
		for (int i = 0; i < len; i++) {
		    if (str.charAt(i) == 'e')
		        counter++;

		}
		  if (counter >= 1 && counter <= 3)
		    return true;
		  else
			return false;
	}
	

	}
