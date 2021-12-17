package com.currency;

import java.util.Scanner;

public class calculateCurrency {
	public static void main(String[] args) {
		String convertFrom;
		String convertTo;
		double amount;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter convert From : (Rupee OR USD or Euro) ");
		convertFrom = sc.nextLine();  //Rupee OR USD or Euro
		System.out.println("Enter convert To : (Rupee OR USD or Euro) ");
		convertTo = sc.nextLine();    //Rupee OR USD or Euro
		System.out.println("Enter amount To convert: ");
		amount = sc.nextDouble();
		
		if(convertTo.equals("Rupee")) {
			Rupee c = new Rupee();
			c.conversion(amount, convertFrom);
		}
		else
			if(convertTo.equals("USD")) {
			Dollar c = new Dollar();
			c.conversion(amount, convertFrom);
		}
			else
				if(convertTo.equals("EURO")) {
				Euro c = new Euro();
				c.conversion(amount, convertFrom);
			}
		sc.close();
	}

}
