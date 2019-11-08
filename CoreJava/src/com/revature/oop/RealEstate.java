package com.revature.oop;

public abstract class RealEstate implements AddressBuilder, AreaCalculation {
	
	
	/*public int stockNumber;
	public double length;
	public double width;
	public String zipCode;
	public String state;
	public String city;
	public String street;
	public String number;*/
	
	public RealEstate() {
		super();		
	}
	


	public  double totalArea(double length, double width, int stockNumber) {
		 double totalArea=length*width*stockNumber;
		 System.out.println(totalArea);
		 return totalArea;
	}
	
	public void buildAddress (String zipCode, String state, String city, String street, String number) {
		System.out.println(zipCode + state + city + street + number);
		}
	}

	

