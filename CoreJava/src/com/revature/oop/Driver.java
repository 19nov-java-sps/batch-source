package com.revature.oop;

import java.io.IOException;
import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {

		//Instantiate an OfficeBuilding object, which can implement all the methods of all superclass's and Interfaces.
		
		System.out.println("Office 1 -----------------------------------------------");	
		
		OfficeBuilding office1 = new OfficeBuilding(5, 200.00,300.00, 
				"10007", "NY", "New York", "Broadway", "1077", 0, 0.2, 25.22);
		
		
		
		
		office1.printAddress();
		System.out.println(Arrays.toString(office1.buildAddress()));
		System.out.println("Total investments " + office1.investment);
		System.out.println("Total area " + office1.totalArea());
		System.out.println("Total rent " + office1.totalRent());	
		try {
			System.out.println("Calculated ROI " + office1.ROI());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.println("Deviding by 0 is not allowed");
		}	
		try {
			System.out.println("Calculated ofice ROI " + office1.officeROI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		System.out.println("Is the plot a square? " + office1.isSquare());
		
		System.out.println("Office 2 -----------------------------------------------");	

		//Instantiate new OfficeBuilding object with an access only to RealEstate methods
		
		RealEstate office2 = new OfficeBuilding();
		
		//Assign values to the variables using setters and getters
		office2.setZipCode("15002");
		office2.setStreet("MacDonalds");
		office2.setNumber("15");
		office2.setState("NY");
		office2.setCity("Detroit");
		
		
		
		//Assign values to variables, declared in OfficeBuilding class (casting)
		
		((OfficeBuilding) office2).setLength (200.00);
		((OfficeBuilding) office2).setWidth(300.00);
		((OfficeBuilding) office2).setStockNumber(5);
		((OfficeBuilding) office2).setVacancyRate(0.1);

		//The same but for Commercial class
		
		((Commercial) office2).setInvestment(0);
		((Commercial) office2).setRentRatePerSquareFeet(9.45);

		
		office2.printAddress();
		System.out.println(Arrays.toString(office2.buildAddress()));
		System.out.println("Total area " + office2.totalArea());
		System.out.println("Is the plot a square? " + office2.isSquare());
		
		//Methods and a variable which don't work because there are not in the RealEstate class, but in child classes
		
		//System.out.println("Total investments " + office2.investment); - Commercial class
		//System.out.println("Total rent " + office2.totalRent());	 - Commercial class
		//System.out.println("Calculated ROI " + office2.ROI());	 - Commercial class
		//System.out.println("Calculated office ROI " + office2.officeROI());	 - OfficeBuilding class
		
		System.out.println("Office 3 -----------------------------------------------");	
		
		//Instantiate new OfficeBuilding object with an access only to RealEstate methods
		
		Commercial office3 = new OfficeBuilding();
		
		//Assign values to the variables using setters and getters
		office3.setZipCode("14002");
		office3.setStreet("DonCarleone");
		office3.setNumber("666");
		office3.setState("CA");
		office3.setCity("Los Angeles");
		
		//Assign values to variables, declared in OfficeBuilding class (casting)
		
		((OfficeBuilding) office3).setLength (200.00);
		((OfficeBuilding) office3).setWidth(200.00);
		((OfficeBuilding) office3).setStockNumber(5);
		((OfficeBuilding) office3).setVacancyRate(0.5);

		//for Commercial class works because they are declared there
		
		office3.setInvestment(0);
		office3.setRentRatePerSquareFeet(.45);

		
		office3.printAddress();
		System.out.println(Arrays.toString(office3.buildAddress()));
		System.out.println("Total area " + office3.totalArea());
		
		System.out.println("Total investments " + office3.investment); 
		System.out.println("Total rent " + office3.totalRent());	
		try {
			System.out.println("Calculated ROI " + office3.ROI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		//Methods still doesn't work
		//System.out.println("Calculated office ROI " + office2.officeROI());	 - OfficeBuilding class
		
		
		System.out.println("Is the plot a square? " + office3.isSquare());
		
		//Calling of the hashcode method from RealEstate super class
		
		RealEstate.compareStates (office1, office2);
		
		//Implement hashCode method
	
			if (office1.state.hashCode()==office2.state.hashCode()) {
				System.out.println("State of a " + office1 + " and " + office2 + " are the same!");
			}
			else {
				System.out.println("State of a " + office1 + " and " + office2 + " are not the same!");
			}

	}


}
