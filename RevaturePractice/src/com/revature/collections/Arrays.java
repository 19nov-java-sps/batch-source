package com.revature.collections;

public class Arrays {

	public static void main(String[] args) {
		// loop through entire array and print each value
		System.out.println("Index\tValue");
		int[] arr = { 5, 10, 15, 20, 25 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + "\t" + arr[i]);

		}
		System.out.println("\n");

		// find sum of all elements inside array
		int[] arr2 = { 11, 21, 31, 41, 51 };
		int sum = 0;
		for (int j = 0; j < arr2.length; j++) {
			sum += arr2[j];
		}
		System.out.println("Sum of the array is " + sum);
		
		System.out.println("\n");
		//for each loop
		int[] arr3 = {11,22,33,44,55};
		int total=0;
		for (int i : arr3) {
		total+=i;
		}
		System.out.println(total);

	}

}
