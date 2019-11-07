package com.revature.Robert;

public class Driver {



	public static void main(String [] args) throws NegativeWageException {
	
		int hours=40;
	
	
	Employee Robert = new SoftwareEngineer(31, "Robert", "Bucci");// This is my example of polymorphism.
	
	
	SoftwareEngineer Donovan= new SoftwareEngineer(33,"Donovan", "Smith");
	
	BusinessAnalyst Anastasia= new BusinessAnalyst(21, "Anastasia", "Smirnov");
	
	
	
	//this will cause my Negative Wage Error to be thrown.
	Anastasia.setWage(-1);
	

	
	
	
	
	
System.out.print(Anastasia.calcPay(Anastasia.getWage(), hours));
	
	

	System.out.println(Anastasia.equals(Donovan));
	
	System.out.println(Anastasia.hashCode());
	
	
	
	
	
	
	
	
	
	
	}

	 
	
	
}


