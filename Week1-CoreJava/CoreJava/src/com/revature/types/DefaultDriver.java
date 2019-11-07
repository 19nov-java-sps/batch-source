package com.revature.types;

import java.util.Arrays;

public class DefaultDriver {

	static int i;
	static boolean bool;
	static char ch;
	static String str;
	static Object obj;
	static boolean[] arr = new boolean[4];
	
	public static void main(String[] args) {
		int localVar;
		System.out.println(i);
		System.out.println(bool);
		System.out.println(ch);
		System.out.println(str);
		System.out.println(obj);
		System.out.println(arr[3]);
		System.out.println(Arrays.toString(arr));
		
			
	}
	
	public static void otherMethod() {
//		System.out.println(localVar);
	}

}
