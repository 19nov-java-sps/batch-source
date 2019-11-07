package com.revature.vehicles;
//any type of extend is an example of inheritance because it retains all of the super class
	//any type of extend is an example of abstraction because it hides all of super class's methods

public class Car extends Vehicle{

	//private hides information from all other classes thus is an example of encapsulation
	private int yearMade;
	private int numWheels;
	
	public Car() {
		super();
		// super is not needed because it is implied but nice to have
		setTypeOfVehicle("Car");
		
	}
	//overloading is an example of having multiple forms or polymorphism
		public Car(int yearMade, int numWheels) {
			this();
			// throws an exception if car is older than 70 years
			if (yearMade < 1950) throw new InvalidYearException("No Car can last 70 years!");
			this.yearMade = yearMade;
			// throws an exception if no wheels
			if (numWheels < 0) throw new NoNegativeInt("No Car runs without wheels!");
			this.numWheels = numWheels;
			
		}
		//getters and setters is how you modify encapsulated data
		public int getYearMade() {
			return yearMade;
		}
		public void setYearMade(int yearMade) {
			this.yearMade = yearMade;
		}
		public int getNumWheels() {
			return numWheels;
		}
		public void setNumWheels(int numWheels) {
			this.numWheels = numWheels;
		}
		// overriding is an example of polymorphism because calling the method produces different results based on objects called
		@Override
		public String toString() {
			return "Car [has " + numWheels + " wheels and is made in " + yearMade+"]";
		}
		//implementation of equals
		//this checks if both objects refer to same object
		public boolean equals(Object obj) 
	    { 
	 
	    if(this == obj) 
	            return true; 
	     if(obj == null || obj.getClass()!= this.getClass()) 
	            return false; 
	 	//compares object to this.object making sure the reference point it the same
	     	Car car = (Car) obj; 

	        return (car.yearMade == this.yearMade && car.numWheels == this.numWheels); 
	    

		}
		//returning numWheels as a hashcode
		public int hashCode() 
	    { 
	          
	        return this.numWheels; 
	    } 
		// overriding is an example of polymorphism because calling the method produces different results based on objects called

		@Override
		public String expectationAverageCost() {
			return "10000 dollars";
		}
		// overriding is an example of polymorphism because calling the method produces different results based on objects called

		@Override
		public int expectationAverageDistanceTraveledInOneHour() {
			return 40;
		}
		// overriding is an example of polymorphism because calling the method produces different results based on objects called

		@Override
		public String expectationAverageLifespan() {
			return "10 years";
		}
		// an example of abstraction because it took the riding method from the interface

		public void riding() {
			System.out.println("Riding a car that will last " 
					+ expectationAverageLifespan()
					+ " that travels "
					+ expectationAverageDistanceTraveledInOneHour()
					+ " miles in an hour and that costs "
					+ expectationAverageCost());
		}
}
	





