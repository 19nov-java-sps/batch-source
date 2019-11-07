package com.revature.types;

public class StringDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string1 = "I am a string";
		String string2 = "I am a string";
		
		System.out.println("with equals " + string1.equals(string2));
		System.out.println("with ==" + string1 == string2);
		
		String alsoString1 = string1;
		//string1 = string1 + "!";
		
		System.out.println(string1);
		System.out.println(alsoString1);
		
		System.out.println("with equals " + string1.equals(alsoString1));
		System.out.println("with ==" + string1 == alsoString1);
		
		
		StringBuilder sb1 = new StringBuilder("I am a StringBuilder Object!");
		StringBuilder sb2 = new StringBuilder("I am a StringBuilder Object!");
		
		System.out.println("with equals " + sb1.toString().equals(sb2.toString()));
		System.out.println("with == " + (sb1 == sb2));
		
		StringBuilder alsoSb1 = sb1;
		System.out.println("with ==" + (sb1 == alsoSb1));
		sb1.append("!!!!");
		
		System.out.println(sb1);
		System.out.println(alsoSb1);
		System.out.println("after changing sb2: " + sb1.toString().equals(alsoSb1.toString()));
		
		String str1 = "Hello world!";
		String str2 = "Hello world!";
		String str3 = new String("Hello world!");
		
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		
		str1=str3;
		System.out.println(str1 == str3);
		

	}

}
