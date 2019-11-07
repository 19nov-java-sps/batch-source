package com.revature.Robert;



//This is my concrete class which implements my CalcPay interface and inherits from Employee and Person.
//This is an example of inheritance.
public class SoftwareEngineer extends Employee implements CalcPay {
	
	
	private double wage;
	
	
	

	public SoftwareEngineer(int age, String firstName, String lastName) {
		super(age, firstName, lastName);
		// TODO Auto-generated constructor stub
	}




	public double getWage() {
		return wage;
	}




	public void setWage(double wage) {
		this.wage = wage;
	}




	@Override
	public int calcPay(int wage, int hours) {
		// TODO Auto-generated method stub
		return wage*hours;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(wage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


//my equals method 

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SoftwareEngineer other = (SoftwareEngineer) obj;
		if (Double.doubleToLongBits(wage) != Double.doubleToLongBits(other.wage))
			return false;
		return true;
	}


	
	



	


	
	

	
	
	
	
	
	
}
