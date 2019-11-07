package com.revature.types;


import java.util.ArrayList;
import java.util.List;

public class Autoboxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//boxing - we explicitly boxing
		int num1 = 5;
		Integer num2 = new Integer(num1);
		
		// unboxing
		Integer num3 = new Integer(8);
		int num4 = num3.intValue();
		
		// autoboxing
		int num5 = 6;
		Integer num6 = num5;
		
		// auounboxing
		
		Integer num7 = new Integer(25);
		int num8 = num7;
		
		List <Integer> myList = new ArrayList<>();
		Integer myInteger = new Integer(5);
;		

	}

}
