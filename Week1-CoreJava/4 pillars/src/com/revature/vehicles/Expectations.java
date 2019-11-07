package com.revature.vehicles;

//an interface is abstraction by default as it hides information
public interface Expectations {
	
	//some abstact methods that are used in other classes
	public String expectationAverageCost();	
	public int expectationAverageDistanceTraveledInOneHour();	
	public String expectationAverageLifespan();
	public void riding();


}
