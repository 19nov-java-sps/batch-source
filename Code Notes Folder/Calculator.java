package com.revature.scanner;

import java.util.Scanner;

public class Calculator {
	
	private static Scanner sc = new Scanner(System.in);//This will create a new scanner Object
	
	public void calculate() {//This is our calculate method which will ask the user to enter the operation they'd like to perform and stores that selection if the input is valid.
		System.out.println("Please enter the operation you'd like to perform:");
		String operation = sc.nextLine();//reads in the input storing it into operation
//		System.out.println(operation);
		
		int[] nums = getNums();//this a method call to getNums which will create an array with spots for two numbers, it will populate that array by using the getNum method. 
//The result will be an array returned and stored in nums variable.
		int result = 0;
		
		switch(operation) {//basic switch statment
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
			while(nums[1]==0) {//if they try to divide by 0, getNums is called and the whole process of selecting two numbers to populate the array begins again.
				System.out.println("Cannot divide by 0, please enter valid operands");
				nums = getNums();
			}
			result = nums[0]/nums[1];
			break;
		default:
			System.out.println("invalid operation");//if they enter an invalid operand calculate is run again and the whole process starts anew.
			calculate();
			return;
		}
		
		System.out.println("The result of your operation is: "+result);//if all input has been successful it shows the result and closes the scanner object.
		sc.close();
	}
	
	private int[] getNums() {
		int[] nums = new int[2];
		System.out.println("Please enter first number:");//uses the getNum method which will validate the data ensuring its a number which will then be stored in this array
		nums[0] = getNum();
		
		System.out.println("Please enter second number:");
		nums[1]= getNum();
		return nums;
	}
	
	private int getNum() {
		String input = sc.nextLine();
		if(input.matches("^\\d+$")) {//data validation to ensure that we're getting an integer or else it runs getNum again to obtain a valid entry.
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
