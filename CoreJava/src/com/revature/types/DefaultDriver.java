package com.revature.types;

import java.util.Arrays;

public class DefaultDriver {
	
	static int i; //default assigned
	static boolean bool;
	static char ch;
	static String str;
	static Object obj;
	static boolean[] arr = new boolean[4];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int localVAr;
		//System.out.println(localVAr);//not default
		System.out.println(i);
		System.out.println(bool);
		System.out.println(ch);
		System.out.println(str);
		System.out.println(obj);
		System.out.println(arr[3]);
		System.out.println(Arrays.toString(arr));
		

	}

}
