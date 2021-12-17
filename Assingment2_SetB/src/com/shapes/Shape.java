package com.shapes;

public class Shape {
	private void calculateArea() {
		
	}
	
}

class Rectangle extends Shape{
	private int length;
	private int breadth;
	public Rectangle(int l,int b) {
		this.length=l;
		this.breadth=b;
	}
	public int calculateArea() {
		return length*breadth;
	}
}
class Square extends Shape{
	private int length;
	public Square(int l) {
		this.length=l;
	}
	public int calculateArea() {
		return length*length;
	}
}
class Triangle extends Shape{
	private int length;
	private int height;
	public Triangle(int l,int h) {
		this.length=l;
		this.height=h;
	}
	public double calculateArea() {
		return 0.5*(length*height);
	}
}