package com.revature.abstraction;

public class MyConcreteClass extends Instrument implements InstrumentInterface {

	//providing concrete context to the abstracted and interfaced methods
	
		@Override
		public void myAbstractMethod() {
			System.out.println("No longer an abstract method");
		}

		@Override
		public void makeSounds() {
			System.out.println("making sounds now!");
		}
	
	}
