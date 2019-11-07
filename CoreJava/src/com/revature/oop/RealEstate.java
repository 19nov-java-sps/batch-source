package com.revature.oop;

public abstract class RealEstate implements AddressBuilder, AreaCalculation {
	
	
	private int stockNumber;
	private double length;
	private double width;
	private String zipCode;
	private String state;
	private String city;
	private String street;
	private String number;
	
	public RealEstate() {
		super();
	}
	
	public  double totalArea(double length, double width, int stockNumber) {
		return this.length*this.width*this.stockNumber;
	}
	
	public String buildAddress (String zipCode, String state, String city, String street, String number) {
		return  this.zipCode + this.state + this.city + this.street + this.number;
		}
	}

	

