package com.revature.vehicles;

public abstract class Vehicles {
	private String Price;
	
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	//using getter/setter/ and private variables, we achieve encapsulation
	
	public Vehicles(){
		super();
	}
	public abstract void Type();
	//using abstract classes we use abstraction
	public void myConcreteMethod() {
		System.out.println("We dont transport passengers");
	}
}
