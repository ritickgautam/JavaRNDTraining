package com.first;


public class SimpleInterest {
	
	   public static void main (String args[])  
	    {  		 int p = 0,r,  t,  si; // principal amount, rate, time and simple interest respectively  
//	             p = 1300; 
	    		 r = 10; t = 2; 
	             try {
	            	System.out.println("Passing string as principal\n");
	            	p=Integer.parseInt("hi");
	            	 
				} catch (NumberFormatException e) {
					p=1200;
					System.out.println(e);
					
						}
	             try {
	            	 System.out.println("Passing negative value as principal\n");
	            	 p=-1200;
					if(p<0) {
						throw new Exception("The principal can't be negative");
					}
				} catch (Exception e) {
					p=1200;
					System.out.println(e);
				}
	             
	             
	             
	             si  = (p*r*t)/100;   
	             System.out.println("Simple Interest is: " +si);  
	    }

}
