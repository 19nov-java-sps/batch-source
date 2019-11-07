package com.revature.types;

public class StringDriver {

	public static void main(String[] args) {
			
		String string1 = "I'm a string!";
		String string2 = "I'm a string!";
		
		System.out.println("with equals " + string1.equals(string2));
		System.out.println("with == " + (string1==string2));
		
		String alsoString1 = string1;
		string1 = string1 + "!";
		
		System.out.println(string1);
		System.out.println(alsoString1);
		
		System.out.println("with equals " + string1.equals(alsoString1));
		System.out.println("with == " + (string1==alsoString1));
		
		
		System.out.println("---------");
		
		StringBuilder sb1 = new StringBuilder("I'm a StringBuilder Object!");
		StringBuilder sb2 = new StringBuilder("I'm a StringBuilder Object!");
		
		System.out.println("with == " + (sb1==sb2));
		System.out.println("with equals " + sb1.toString().equals(sb2.toString()));
		
		StringBuilder alsoSb1 = sb1;
		System.out.println("before changing sb1: " + (sb1 == alsoSb1));
		sb1.append("!!!!!!");
		System.out.println(sb1);
		System.out.println(alsoSb1);
		System.out.println("after changing sb1: " + (sb1 == alsoSb1));

		
		System.out.println("---------");
		
		String str1 = "hello world";
		String str2 = "hello world";
		String str3 = new String("hello world");
		
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		
		str3 = str3.intern();
		System.out.println(str1 == str3);


	}

}
