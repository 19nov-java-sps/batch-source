package com.revature.oop;

public class OfficeBuilding extends Commercial {
	
	int stockNumber;
	double length;
	double width;
	String zipCode;
	String state;
	String city;
	String street;
	String number;
	int investment;
	double vacancyRate;
	
	public OfficeBuilding () {
		super();		
	}
	
	/*public OfficeBuilding (int stockNumber,double length, double width, String zipCode, String state, 
			String city,String street, String number, int investment, double vacancyRate  ) {
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
		
	}*/
	
	public OfficeBuilding(int i, double d, double e, String string, String string2, String string3, String string4,
			String string5, double f, double g) {
		// TODO Auto-generated constructor stub
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

	public double getInvestment() {
		return investment;
	}
	

	public void setInvestment(int investment) {
		this.investment = investment;
	}

	public double officeROI(double totalRent, double vacancyRate, double investment) {
		double officeROI =  (totalRent*this.vacancyRate)/this.investment;		
		 return officeROI;
	}


}
