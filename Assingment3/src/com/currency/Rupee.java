package com.currency;

public class Rupee {
	private double amount=0;
		
	

	public Rupee(double amount2) {
		// TODO Auto-generated constructor stub
		this.amount = amount2;
		
	}


	class Conversion{
		

		ConversionRate ob = new ConversionRate();
		
		public void toDollar() {
			System.out.println(amount*ob.rateToDollar());
		}
		public void toEuro() {
			System.out.println(amount*ob.rateToEuro());
			
		}
		class ConversionRate{
			public double rateToDollar() {
				return 0.013;
			}
			public double rateToEuro() {
				return 0.012;
			}
		}
		
	}
	
}
