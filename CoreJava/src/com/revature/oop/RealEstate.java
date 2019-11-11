package com.revature.oop;

import java.io.IOException;

//Here is my abstract class Real Estate which declares  varuables and methods that are obligatory to use in
//all child classes like Commercial and OfficeBuilding

public abstract class RealEstate implements AddressBuilder, AreaCalculation {
	
	//Here I declare variables of a RealEstate object. I use a protected key word 
	//for the variables to implement encapsulation - the access prevention to the variables from the outside the package.
	//private doesn't work because OfficeBuilding class's method need an access to these variables

	protected String zipCode;
	protected String state;
	protected String city;
	protected String street;
	protected String number;
	private double length;
	private double width;

	//The default constructor for a RealEstate object
	public RealEstate() {
		super();		
	}	

	//An abstract method

	public double totalArea() {
		
		try {
			double totalArea = this.length*this.width;
				if (totalArea !=0) {
				return totalArea;
				}
			} catch (MyCustomException e) {
				 System.out.println("The both paramethers have to be not 0!");
			 }
		 return 0.0;
	}
	
	
	//A concrete method
	
	public String[] buildAddress () {
		String [] address = {this.number,this.street,this.city,this.state,this.zipCode}; //the key word "this" refers to the variables, declared in the same class
		return address;
			}
	
	//Implement equals  method and hashcode method
	public boolean isSquare () {
		Double length = new Double(this.length);
		Double width = new Double(this.width);
		
		if (length.equals(width)) {
			System.out.println("Is square");
		}
		else {
			System.out.println("Is rectangle");
		}
		return this.length != this.width;
	}
	
	public static void compareStates (Object a, Object b) {
	if (a.hashCode()==b.hashCode()) {
		System.out.println("buildings " + a + " and " + b + " are the same!");
	}
	else {
		System.out.println("Buildings a " + a + " and " + b + " are not the same!");
	}
	}

	//Getters and setters for the variables
	
	public int getStockNumber() {
		return getStockNumber();
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}

	

