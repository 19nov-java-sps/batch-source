package com.revature.abstraction;

public abstract class MyAbstractClass {

	public MyAbstractClass() {
		super();
	}
	
	public abstract void myAbstractMethod();
	
	public void myConcreteMethod() {
		System.out.println("we can still have implementation");
	}
}
