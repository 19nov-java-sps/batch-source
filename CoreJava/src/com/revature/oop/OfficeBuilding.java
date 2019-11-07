package com.revature.oop;

public class OfficeBuilding extends Commercial {
	
	private double totalRent;
	private double buildAddress;

	public OfficeBuilding () {
		super();
	}
	
	public OfficeBuilding (double totalRent, String buildAddress) {
		this();
		this.totalRent=totalArea;
		this.buildAddress=rentRatePerSquareFeet;
	}

	@Override
	public double totalRent() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public double totalRent(double totalArea, double rentRatePerSquareFeet) {
		return this.totalArea*this.rentRatePerSquareFeet;
	}

	@Override
	public String buildAddress() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String buildAddress (String zipCode, String state, String city, String street, String number) {
		return  this.zipCode + this.state + this.city + this.street + this.number;
		}
}
