package com.revature.oop;

public abstract class RealEstate implements AddressBuilder, AreaCalculation {
	
	
	int stockNumber;
	double length;
	double width;
	public String zipCode;
	public String state;
	public String city;
	public String street;
	public String number;
	int investment;
	double vacancyRate;
	double rentRatePerSquareFeet; 
	
	public RealEstate() {
		super();		
	}	

	public  double totalArea() {
		 double totalArea=this.length*this.width*this.stockNumber;
		 return totalArea;
	}
	
	public String buildAddress () {
		String address = this.zipCode + this.state + this.city + this.street + this.number;
		return address;
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

	public int getInvestment() {
		return investment;
	}

	public void setInvestment(int investment) {
		this.investment = investment;
	}

	public double getVacancyRate() {
		return vacancyRate;
	}

	public void setVacancyRate(double vacancyRate) {
		this.vacancyRate = vacancyRate;
	}

	public double getRentRatePerSquareFeet() {
		return rentRatePerSquareFeet;
	}

	public void setRentRatePerSquareFeet(double rentRatePerSquareFeet) {
		this.rentRatePerSquareFeet = rentRatePerSquareFeet;
	}	
	
}

	

