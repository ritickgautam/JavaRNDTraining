package com.car.main;

import java.util.Scanner;

import com.car.Car;


public class CarMain {
	static int ctr=0;
	public static void main(String[] args) {
		addCar();
		//System.out.println("Car Sold: "+numberOfCarSold);
		
	}

	public static void addCar()
	{
		Scanner sc= new Scanner(System.in);
		
		int choice;
		while(true)
		{
			Car ob=new Car();
			System.out.println("Enter Speed");
			ob.setSpeed(Integer.parseInt(sc.nextLine()));
			System.out.println("Enter owner name");
			ob.setCarOwner(sc.nextLine());
			System.out.println("Enter Car type");
			ob.setCarType(sc.nextLine());
			ctr++;
			System.out.println("Number of Car sold: "+ctr);
			System.out.println("\nFor exit press 0");
			System.out.println("\nTo add new car press 1");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				addCar();
				break;
			default:
				System.exit(0);
			}
			
		}
		}
	

}
