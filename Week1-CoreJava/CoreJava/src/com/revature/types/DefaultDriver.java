package com.revature.types;

//import java.util.Arrays;

public class DefaultDriver {
	// static and instance scoped variables will be assigned default values
	static int i;
	static boolean bool;
	static char ch;
	static String str;
	static Object obj;
	static boolean[] arr = new boolean[4];
	private int myPrivateInstanceVar = 12;
	
	public static void main(String[] args) {
		int localVar;
//		System.out.println(localVar); // this local (method) variable was not assigned a default value (this would be the same with block scope)
		System.out.println(i);
		System.out.println(bool);
		System.out.println(ch);
		System.out.println(str);
		System.out.println(obj);
		System.out.println(arr[3]);
		// Arrays is a utility class (helpful static methods)
		System.out.println(java.util.Arrays.toString(arr)); // we can use the fully qualified class name instead of importing 
		
		DefaultDriver myDefaultDriverObject = new DefaultDriver();
		System.out.println(myDefaultDriverObject.myPrivateInstanceVar);
		
		myDefaultDriverObject.myInstanceMethod();
	}
	
	public static void otherMethod() {
//		System.out.println(localVar);
	}
	
	public void myInstanceMethod() {
		System.out.println(myPrivateInstanceVar);
	}

}
