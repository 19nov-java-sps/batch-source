package com.revature.oop;

public abstract  class Commercial extends RealEstate implements RentCalculation{
	
	public Commercial(){
		super();		
	}	

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

	public double totalRent() {
		 double totalRent = this.totalArea()*this.rentRatePerSquareFeet;
		 return totalRent;
	}
	

	public double ROI() {
		return this.totalRent()/this.investment;		
	}
}
