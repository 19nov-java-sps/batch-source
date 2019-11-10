package com.revature.oop;

import java.io.IOException;

public class OfficeBuilding extends Commercial implements RoomNumberAssigner {
	
	
	public int stockNumber;
	public double length;
	public double width;
	double vacancyRate;
	
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
	
	public double officeROI() throws IOException  {
		
		double officeROI =  (this.totalRent()*this.vacancyRate)/this.investment;
		return officeROI;
	}

	public double getVacancyRate() {
		return vacancyRate;
	}

	public void setVacancyRate(double vacancyRate) {
		this.vacancyRate = vacancyRate;
	}

	@Override
	public  double totalArea() {
		// double totalArea=this.length*this.width;
		 return RentCalculation.totalArea(length, width);
	}

	public int getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}	
	
	

}
