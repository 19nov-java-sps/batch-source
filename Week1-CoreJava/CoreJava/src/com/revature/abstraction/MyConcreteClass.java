package com.revature.abstraction;

public class MyConcreteClass extends MyAbstractClass implements InterfaceA,InterfaceB {

	@Override
	public void myAbstractMethod() {
		System.out.println("not abstract anymore");
		
	}

	@Override
	public void doSomething() {
		System.out.println(myInt);		
	}

	@Override
	public void doSomethingElse() {
		InterfaceA.super.doSomethingElse();
	}

}
