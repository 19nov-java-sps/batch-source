package com.revature.oop;

import java.io.IOException;

public abstract  class Commercial extends RealEstate implements RentCalculation{
	
	
	//Declare variables, used in this class's methods
	int investment;
	double rentRatePerSquareFeet; 
	public double length;
	public double width;
	
	public Commercial(){
		super();		
	}		
	
	public double totalRent() {
		 double totalRent = this.totalArea()*this.rentRatePerSquareFeet;
		 return totalRent;
	}

	public double ROI() throws IOException {
		return this.totalRent()/this.investment;		
	}
	
	//Getters and setters for the class variables
	
	public int getInvestment() {
		return investment;
	}

	public void setInvestment(int investment) {
		this.investment = investment;
	}

	public double getRentRatePerSquareFeet() {
		return rentRatePerSquareFeet;
	}

	public void setRentRatePerSquareFeet(double rentRatePerSquareFeet) {
		this.rentRatePerSquareFeet = rentRatePerSquareFeet;
	}

	@Override
	public double totalArea() {
		return AreaCalculation.totalArea(length, width);
	}
}
