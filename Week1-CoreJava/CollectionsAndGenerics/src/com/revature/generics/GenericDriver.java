package com.revature.generics;

import java.util.ArrayList;

public class GenericDriver {

	public static void main(String[] args) {

		/*
		 * this will compile but a ClassCastException will be thrown at runtime
		 */
//		ArrayList arrList = new ArrayList();
//		arrList.add("test");
//		int str = (int) arrList.get(0);

		/*
		 * 
		 */
		ArrayList<String> arrList = new ArrayList<>();
		arrList.add("test");
//		int str = (int) arrList.get(0); // this would not compile 
		String str = arrList.get(0);
		
		Integer[] intArr = {1,2,3,4,5};
		
		printAll(intArr);
		
		String[] strArr = {"Hello", "World", "Blue", "Green"};
		
		printAll(strArr);
		

	}
	
//	public static void printAll(Integer[] arr) {
//		for(Integer i: arr) {
//			System.out.println(i);
//		}
//	}
//	
//	public static void printAll(String[] arr) {
//		for(String i: arr) {
//			System.out.println(i);
//		}
//	}
	
	/*
	 * instead of overloading "printAll" for every type of array 
	 * we can put T as a placeholder to parameterize the type 
	 */
	public static <T> void printAll(T[] arr) {
		for(T item: arr) {
			System.out.println(item);
		}
	}

}
