package com.revature.vehicles;

//any type of extend is an example of inheritance because it retains all of the super class
//any type of extend is an example of abstraction because it hides all of super class's methods

public class Ford extends Car{
	//private hides information from all other classes thus is an example of encapsulation

	private String model;
	
	//lets ford inherit from car
	public Ford() {
		super();
	}
	
	//created ford object
	public Ford(String model) {
		this ();
		this.model = model;
		
	}
	//getters and setters is how you modify encapsulated data
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	// overriding is an example of polymorphism because calling the method produces different results based on objects called
	
	@Override
	public String expectationAverageCost() {
		return "50000 dollars";
	}
	@Override
	public int expectationAverageDistanceTraveledInOneHour() {
		return 100;
	}
	@Override
	public String expectationAverageLifespan() {
		return "20 years";
	}
	@Override
	public String toString() {
		return "Ford [Model is " + model+"]";
		}
		// an example of abstraction because it took the riding method from the interface

		public void riding() {
			System.out.println("Riding a " 
					+ model
					+ " Ford that will last " 
					+ expectationAverageLifespan()
					+ " that travels "
					+ expectationAverageDistanceTraveledInOneHour()
					+ " miles in an hour and that costs "
					+ expectationAverageCost());
		


}//implementation of equals
		//this checks if both objects refer to same object
	public boolean equals(Object obj) 
    { 
 
    if(this == obj) 
            return true; 
     if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
	 	//compares object to this.object making sure the reference point it the same
     	Ford ford = (Ford) obj; 

        return (ford.model == this.model); 
    

	}
	//converts string model to a hashcode

	@Override
	public int hashCode() 
    { 
          
        return this.model.hashCode(); 
    } 

}