package com.revature.abstraction;

public abstract class MyAbstractClass {
	
	//can include both concrete and abstract methods
	//can include instance variables

	public abstract void myAbstractMethod();
	
	public void myConcreteMethod() {
		System.out.println("We can still have implementation");
		
	}
}
