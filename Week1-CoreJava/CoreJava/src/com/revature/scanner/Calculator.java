package com.revature.scanner;

import java.util.Scanner;

public class Calculator {
	
	private static Scanner sc = new Scanner(System.in);
	
	public void calculate() {
		System.out.println("Please enter the operation you'd like to perform:");
		String operation = sc.nextLine();
//		System.out.println(operation);
		
		int[] nums = getNums();
		int result = 0;
		
		switch(operation) {
		case "addition":
			result = nums[0] + nums[1];
			break; // this prevents fall through
		case "subtraction":
			result = nums[0] - nums[1];
			break;
		case "multiplication":
			result = nums[0]*nums[1];
			break;
		case "division":
			while(nums[1]==0) {
				System.out.println("Cannot divide by 0, please enter valid operands");
				nums = getNums();
			}
			result = nums[0]/nums[1];
			break;
		default:
			System.out.println("invalid operation");
			calculate();
			return;
		}
		
		System.out.println("The result of your operation is: "+result);
		sc.close();
	}
	
	private int[] getNums() {
		int[] nums = new int[2];
		System.out.println("Please enter first number:");
		nums[0] = getNum();
		
		System.out.println("Please enter second number:");
		nums[1]= getNum();
		return nums;
	}
	
	private int getNum() {
		String input = sc.nextLine();
		if(input.matches("^\\d+$")) {
			return Integer.parseInt(input);
		} else {
			System.out.println("Invalid input; please enter an integer");
			return getNum();
		}
	}

	/*
	private int getNum2() {
		try{
			int input = sc.nextInt();
			return input;
		} catch (NumberFormatException e) {
			System.out.println("Invalid input; please enter an integer");
			return getNum2();
		}
	}
	*/
	
}
