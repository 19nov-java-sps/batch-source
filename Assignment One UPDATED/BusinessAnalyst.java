package com.revature.Robert;









public class BusinessAnalyst extends Employee implements CalcPay {
	
	
	private int  wage;//This is set to private to protect the data from being accessed without using a getter or setter method representing the pillar of encapusulation
	
	
	public BusinessAnalyst(int age, String firstName, String lastName) {
		super(age, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	






	public int getWage() {
		return wage;
	}

//my exception handling
public void setWage(int wage) throws com.revature.Robert.NegativeWageException {
	
	
if(wage<=0) {
	throw new NegativeWageException("The Wage cannot be less than zero" + " " + "The wage you entered is:" + wage + " " );
}
	
	

}












	private Exception NegativeWageException() {
	// TODO Auto-generated method stub
	return null;
}








	@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + wage*wage%10;
	return result;
}








@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	BusinessAnalyst other = (BusinessAnalyst) obj;
	if (wage != other.wage)
		return false;
	return true;
}








	@Override
	public int calcPay(int wage, int hours)  {
		
		
	
			
return wage * hours;		

		
		
		
		
	}


	
	



	
	
	
	
	
	
	
	

}
