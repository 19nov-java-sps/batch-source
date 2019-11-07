package com.revature.abstraction;

public class Driver {

	public static void main(String[] args) {
		MyConcreteClass c = new MyConcreteClass();
	    c.myAbstractMethod();
		c.myConcreteMethod();
		c.doSomething();
	}
	

}
