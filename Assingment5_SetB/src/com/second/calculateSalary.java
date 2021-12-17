package com.second;

public class calculateSalary {
	private int gs; 
	int incomeTax=1000; 
    int providentFund=800;    
    int professionalTax=500;
    int net_salary=0;
    public calculateSalary(int gross) {
    	this.gs = gross;
    	net_salary=gross - (incomeTax+professionalTax+providentFund);
    	
    	System.out.println("Net salary "+ net_salary);
    	
    	}
}
