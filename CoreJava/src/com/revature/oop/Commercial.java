package com.revature.oop;

public abstract  class Commercial extends RealEstate implements RentCalculation{
	
	public double investment;
	double rentRatePerSquareFeet; 


	
	public Commercial(){
		super();		
	}
	


	
	public double getInvestment() {
		return investment;
	}




	public void setInvestment(double investment) {
		this.investment = investment;
	}




	public double getRentRatePerSquareFeet() {
		return rentRatePerSquareFeet;
	}




	public void setRentRatePerSquareFeet(double rentRatePerSquareFeet) {
		this.rentRatePerSquareFeet = rentRatePerSquareFeet;
	}




	public double totalRent(double totalArea, double rentRatePerSquareFeet) {
		 double totalRent = totalArea*rentRatePerSquareFeet;
		 return totalRent;
	}
	

	public double ROI(double totalRent, int investment) {
		return totalRent/investment;		
	}
}
