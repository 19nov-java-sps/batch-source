package com.revature.abstraction;
//Abstraction - creating an abstraction interface with a method
public interface Strummable {

		public default void strumGuitar() {
			System.out.println("Strumming the guitar chords!");
		}
}
