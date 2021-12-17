package com.second;

import java.util.Scanner;

class Myexception1 extends Exception{
	public Myexception1(String error) {
		super(error);
	}
	
}

class Myexception2 extends Exception{
	public Myexception2(String error) {
		super(error);
	}
}

public class customExceptionMain {
	public static void main(String[] args) throws Myexception1, Myexception2 {
		calculateSalary cs;
		int gs=0;
		Scanner sc = new Scanner(System.in);	
		try {
				System.out.println("Enter gross salary");
				if(!sc.hasNextInt()) {
					throw new Myexception1("Gross-salary type Exception");
				}
				gs=sc.nextInt();
				if(gs<0) 
				{
					throw new Myexception2("Negative Gross salary exception");
				}
				else
				cs = new calculateSalary(gs);	
			}
		catch (Myexception1 e) {
					System.out.println(e);	
				}
		catch (Myexception2 e) {
					System.out.println(e);
				}
		
	}

}
