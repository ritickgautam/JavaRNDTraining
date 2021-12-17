package com.second;

import java.io.DataInputStream;
import java.io.IOException;

public class SimpleInterestMain {
	public static void main(String[] args) throws IOException, IntegerTypeException, NegativeException{
		int r=10;
		int t=2;
		int principal=0;
		int si;
		String p=null;
		DataInputStream di = new DataInputStream(System.in);
		System.out.println("Enter Principal Amount ");
		try {
			p= di.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				}
		try {
			principal= Integer.parseInt(p);
		} catch (Exception e) {
			throw new IntegerTypeException("Invalid type(not Integer)");
		}
		
		try {
			if(principal<0) {

				throw new NegativeException("Principal in negative");
			}
			
		} 		
		finally {

			System.out.println("Your enter principal is "+ principal + "\n" + "Enter rate is " + r + "\n" + "Enter Time is " + t );
	        si  = (principal*r*t)/100;   
	        System.out.println("Simple Interest is: " +si);  	
		}
	}
	

}
