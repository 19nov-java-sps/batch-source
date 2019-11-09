package com.revature.oop;

public class OfficeBuilding extends Commercial {
	

	
	public OfficeBuilding () {
		super();		
	}
	
	public OfficeBuilding (int stockNumber,double length, double width, String zipCode, String state, 
			String city,String street, String number, int investment, double vacancyRate, double rentRatePerSquareFeet  ) {
		this();
		this.stockNumber=stockNumber;
		this.length=length;
		this.width=width;
		this.zipCode=zipCode;
		this.state=state;
		this.city=city;
		this.street=street;
		this.number=number;
		this.investment=investment;
		this.vacancyRate=vacancyRate;
		this.rentRatePerSquareFeet=rentRatePerSquareFeet;
		
	}
	
	public double officeROI() {
		double officeROI =  (this.totalRent()*this.vacancyRate)/this.investment;		
		 return officeROI;
	}


}
