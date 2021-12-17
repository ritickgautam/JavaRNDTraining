package com.currency;

public class Dollar extends Currency{
	public void conversion(double x, String toDollar) {
		if(toDollar.equals("EURO"))
		{
			System.out.println(x*1.13);	
			
		}
		else {
			System.out.println(x*0.013);	
		}
	}

}
