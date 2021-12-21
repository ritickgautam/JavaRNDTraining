package com.collectionPracticals;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

class Employee{
	private int empCode;
	private String empName;
	private String Address;
	public Employee(int empCode, String empName, String address) {
		super();
		this.empCode = empCode;
		this.empName = empName;
		this.Address = address;
	}
	@Override
	public String toString() {
		return "Employee [empCode=" + empCode + ", empName=" + empName + ", Address=" + Address + "]";
	}
	
	
}

public class third {
	public static void main(String[] args) {
		List<Employee> employeeDetails = new Vector<Employee>();
		addInput(employeeDetails);
		display(employeeDetails);
				
	}
	public static void display(List<Employee> employeeDetails) {
		Enumeration e=Collections.enumeration(employeeDetails);
		System.out.println("Employee details ");
		while(e.hasMoreElements())
		       System.out.println(e.nextElement());
	}

	public static void addInput(List<Employee> employeeDetails) {
		System.out.println("Enter Employee Details");
		employeeDetails.add(new Employee (101, "Ritick" , "Bokaro"));
		employeeDetails.add(new Employee (102, "Abhishek" , "Delhi"));
		employeeDetails.add(new Employee (102, "Rahul" , "Ranchi"));
		employeeDetails.add(new Employee (102, "Abhimanyu" , "Hyderabad"));
			
	}
}
