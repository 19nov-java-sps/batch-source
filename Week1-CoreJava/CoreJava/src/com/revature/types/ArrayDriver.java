package com.revature.types;

import java.util.Arrays;

public class ArrayDriver {

	public static void main(String[] args) {
	
		int[] intArr1 = new int[5];
		int intArr2[] = new int[5];
		int[] intArr3 = {7,3,4,1};
		
		System.out.println(intArr3[2]);
//		System.out.println(intArr3[12]);

		for(int i=0; i<intArr3.length; i++) {
			System.out.print(intArr3[i] + " ");
		} 
		System.out.println();
		
		// we can do this for arrays or anything that implements the Iterable interface
		for(int currentInt: intArr3) {
			System.out.print(currentInt+ " ");
		}
		
		int[][] int2DArr = new int[3][3];
		
		System.out.println();
		
		printAll();
		System.out.println();
		printAll("Hello");
		System.out.println();
		printAll("Hello","World", "Cat", "Dog", "Octopus");
		
	}
	
	public static void printAll(String... strArr) {
//		System.out.println(Arrays.toString(strArr));
		for(String str: strArr) {
			System.out.print( str +" ");
		}
	}

}
