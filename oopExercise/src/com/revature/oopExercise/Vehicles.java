package com.revature.oopExercise;

import com.revature.Exceptions.myException;

public abstract class Vehicles {
	private int howManyDoIOwn;
	public int getHowManyDoIOwn() {
		return howManyDoIOwn;
	}
	public void setHowManyDoIOwn(int howManyDoIOwn) throws Exception {
		if(howManyDoIOwn<0) {
			throw new myException("Can't own negative vehicles");
		}
		this.howManyDoIOwn = howManyDoIOwn;
	}
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
