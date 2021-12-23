package com.currency;

public class Dollar{
	private double amount=0;
		
	

	public Dollar(double amount2) {
		// TODO Auto-generated constructor stub
		this.amount = amount2;
	}
		class Conversion{
			

			ConversionRate ob = new ConversionRate();
			
			public void toRupee() {
				System.out.println(amount*ob.ratetoRupee());
			}
			public void toEuro() {
				System.out.println(amount*ob.rateToEuro());
				
			}
			class ConversionRate{
				public double ratetoRupee() {
					return 75.22;
				}
				public double rateToEuro() {
					return 0.88;
				}
			}
			
		}	
	}


	
	
	