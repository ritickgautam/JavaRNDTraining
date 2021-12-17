package com.currency;

public class Rupee extends Currency{
	public void conversion(double x, String toRupee) {
		if(toRupee.equals("USD"))
		{
			System.out.println(x*74);	
			
		}
		else {
			System.out.println(x*86);	
		}
	}
}
