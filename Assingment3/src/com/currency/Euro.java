package com.currency;


public class Euro{
private double amount=0;
		
	

	public Euro(double amount2) {
		// TODO Auto-generated constructor stub
		this.amount = amount2;
	}
		class Conversion{
			

			ConversionRate ob = new ConversionRate();
			
			public void toRupee() {
				System.out.println(amount*ob.ratetoRupee());
			}
			public void toDollar() {
				System.out.println(amount*ob.rateToDollar());
				
			}
			class ConversionRate{

				public double ratetoRupee() {
					return 85.06;
				}
				public double rateToDollar() {
					return 1.13;
				}
			}
			
		}	
	}


	