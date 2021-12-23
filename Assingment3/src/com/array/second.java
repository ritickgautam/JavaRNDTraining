package com.array;

public class second {
	 public static void main(String[] args) {
		 double ar[]= {2.4,4.5,4.2,5.0,8.2};
		 reverse(ar);

		 }
		 public static void reverse(double ar[]) {
		 int i = 0, j = ar.length - 1;
		    for (i = 0; i < ar.length / 2; i++, j--) {
		        double temp = ar[i];
		        ar[i] = ar[j];
		        ar[j] = temp;
		    }
		    System.out.println("Reversed array");
		 for(double element : ar) {
		 System.out.println(element);
		 }
		 }

}
