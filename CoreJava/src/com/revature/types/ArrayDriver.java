package com.revature.types;

import java.util.Arrays;

public class ArrayDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] intArr1 = new int[5];
		int intArr2 [] = new int [5];
		int[] intArr3 = {7,3,4,2};
		
		System.out.println(intArr3[2]);
		//System.out.println(intArr3[12]);
		
		System.out.println("---------------------------------------");
		
		for(int i=0; i<intArr3.length; i++) {
			System.out.println(intArr3[i] + " ");
		}
		
		System.out.println("---------------------------------------");
		
		//printALL();
		System.out.println();
		

		
		
		for(int i: intArr3) {
			System.out.print(i+" ");
		}
		
		int[][] int2DArr = new int[3][3];
		
		printAll();
		System.out.println();
		printAll("Hello");
		System.out.println();
		printAll("Hello","World","Cat","Dog");
		
		
	}
		public static void printAll(String... strArr) {
			System.out.print(Arrays.deepToString(strArr));
		
			
			for(String str: strArr) {
				System.out.print(str + " ");
			}
		}
	}


