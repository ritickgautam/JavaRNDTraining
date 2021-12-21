package com.collectionPracticals;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

class product{
	Hashtable<Integer , String> products = new Hashtable<Integer, String>();
	Scanner sc = new Scanner(System.in);
	
	public void store() {

		System.out.println("Enter the product details");
		for (int i = 0; i < 10; i++) {
			System.out.println("Enter Product "+ (i+1) + " id");
			int pro_id =sc.nextInt();
			System.out.println("Enter Product "+ (i+1) + "  Name");
			String pro_name = sc.next();
			products.put(pro_id, pro_name);
		}
		System.out.println("The list of Hash table is ");
		for(Map.Entry m:products.entrySet()) {
			System.out.println(m.getKey()+" "+ m.getValue());
		}
	
	}
	public void search() {
		System.out.println("--------------");
		System.out.println("Enter the product you want to search for: ");
		String search_product=sc.next();//"Apple";
		System.out.println("the product you have searched for: " + search_product);
		if(products.containsValue(search_product))
		{
			System.out.println("Yes it is available");
		}
		else
			System.out.println("No it is not available");
	}
	public void remove_product() {
		System.out.println("---------------");
		System.out.println("Enter the Product Id you want to remove: ");
		int delete_productId = sc.nextInt();
		String returned_value = (String)products.remove(delete_productId);
		System.out.println("Removed value is: " + returned_value);
		System.out.println("New Hashtable is: " + products);
		
	}
	
}

public class second {
	public static void main(String[] args) {
		product ob=new product();
		ob.store();
		ob.search();
		ob.remove_product();
	}

}
