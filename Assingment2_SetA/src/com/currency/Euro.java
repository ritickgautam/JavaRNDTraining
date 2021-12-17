package com.currency;

public class Euro extends Currency{
	public void conversion(double x, String toEuro) {
		if(toEuro.equals("USD"))
		{
			System.out.println(x*0.89);	
			
		}
		else {
			System.out.println(x*0.012);	
		}
	}
}
