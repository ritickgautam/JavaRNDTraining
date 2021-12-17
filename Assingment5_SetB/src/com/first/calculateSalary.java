package com.first;

public class calculateSalary {
	public static void main(String[] args) {

	    int grossSalary=10000;
	    int incomeTax=1000; 
	    int providentFund=800;    
	    int professionalTax=500;
	
	    try {
	    	System.out.println("Passing String as gross salary ");
	    	grossSalary=Integer.parseInt("hi");
       	 
		} catch (Exception e) {
			grossSalary=10000;
			System.out.println(e);
			}
	    try {
	    	System.out.println("Passing negative as gross salary ");
	    	grossSalary=-10000;
			if(grossSalary<0) {
				throw new Exception("The gross Salary can't be negative");
			}
		} catch (Exception e) {
			grossSalary=10000;
			System.out.println(e);
		}

	    int netSalary=grossSalary-(incomeTax+providentFund+professionalTax);
	    System.out.println("Net Salary is="+netSalary);
	}
}
