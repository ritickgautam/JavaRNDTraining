package com.shapes;

import java.util.Scanner;

public class calculateArea {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the shape:(S-Sqaure | R-Rectangle | T-Triangle) ");
		String shapeType;
		shapeType=sc.nextLine();
		if(shapeType.equals("S")) {
			System.out.println("Enter the side of square ");
			int side = sc.nextInt();
			Shape s = new Square(side);
			Square s1= (Square)s;
			System.out.println("The area for squareis: "+ s1.calculateArea());
		}
		else
			if(shapeType.equals("R")) {
			System.out.println("Enter the length of rectangle ");
			int len=sc.nextInt();
			System.out.println("Enter the breadth of rectangle ");
			int breadth=sc.nextInt();
			Shape s = new Rectangle(len,breadth);
			Rectangle r1= (Rectangle)s;
			System.out.println("The area for rectangle: "+ r1.calculateArea());
		}
		else
			if(shapeType.equals("T")) {
			System.out.println("Enter the length of triangle ");
			int len=sc.nextInt();
			System.out.println("Enter the height of triangle ");
			int height=sc.nextInt();
			Shape s = new Triangle(len,height);
			Triangle t1= (Triangle)s;
			System.out.println("The area for Triangle: "+ t1.calculateArea());
		}
		
	}

}
