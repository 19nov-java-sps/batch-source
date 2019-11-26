package com.revature.abstraction;

public class MyConcreteClass extends MyAbstractClass implements InterfaceA, InterfaceB {

	@Override
	public void myAbstractMethod() {
		System.out.println("not so abstract anymore");
	}

	@Override
	public void doSomething() {
		System.out.println("doing something");
	}

	@Override
	public void doSomethingElse() {
		InterfaceA.super.doSomethingElse();
	}
	
//	@Override -- cannot put @Override over a method that is not being overridden
//	public void someOtherMethod() {
//		
//	}

}
