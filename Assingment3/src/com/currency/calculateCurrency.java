package com.currency;

import java.util.Scanner;

public class calculateCurrency {
	static Scanner sc=new Scanner(System.in);
	static class staticaddamount {
		static double amt=0;
		public static void addamount(double amount) {
			amt = amt+amount;
		}
		public static void show() {
			System.out.println("Total amount converted is " + amt);
		}
	}
	public static void main(String[] args) {
		String convertFrom;
		String convertTo;
		double amount;
		
		
		boolean flag=true;
		while(flag) {
			System.out.println("Enter convert From : (Rupee OR USD or Euro) OR 0 for EXIT ");
			convertFrom = sc.nextLine();  //Rupee OR USD or Euro
			if(convertFrom.equals("0"))
			{
				flag=false;
				staticaddamount.show();
				System.exit(0);
			}
			System.out.println("Enter convert To : (Rupee OR USD or Euro) ");
			convertTo = sc.nextLine();    //Rupee OR USD or Euro
			System.out.println("Enter amount To convert: ");
			amount = Double.parseDouble(sc.nextLine());
		
			if(convertFrom.equals("Rupee")) {
				Rupee r = new Rupee(amount);
				Rupee.Conversion obj = r.new Conversion();
				staticaddamount.addamount(amount);
				switch (convertTo) {
				case "USD":
					obj.toDollar();
					break;
					
				case "Euro":
					obj.toEuro();
					break;
				default:
					System.out.println("Invalid selection");
					break;
				}
				
			}
			else
				if(convertFrom.equals("USD")) {
					Dollar r = new Dollar(amount);
					Dollar.Conversion obj = r.new Conversion();
					staticaddamount.addamount(amount);
					switch (convertTo) {
					case "Rupee":
						obj.toRupee();
						break;
						
					case "Euro":
						obj.toEuro();
						break;
					default:
						System.out.println("Invalid selection");
						break;
					}
			}
				else
					if(convertFrom.equals("EURO")) {
						Euro r = new Euro(amount);
						Euro.Conversion obj = r.new Conversion();
						staticaddamount.addamount(amount);
						switch (convertTo) {
						case "Rupee":
							obj.toRupee();
							break;
							
						case "Dollar":
							obj.toDollar();
							break;
						default:
							System.out.println("Invalid selection");
							break;
						}
				}

		}
		sc.close();
	}

}
