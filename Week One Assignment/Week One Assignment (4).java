package com.revature.Robert;


//second abstract class which extends Person, taking the template.
public abstract class Employee extends Person{
	
	
//utilizing proper modifiers
	private String empType;
	
	
	
	//My equals method 
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empType == null) {
			if (other.empType != null)
				return false;
		} else if (!empType.equals(other.empType))
			return false;
		return true;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((empType == null) ? 0 : empType.hashCode());
		return result;
	}






	
	

	public Employee(int age, String firstName, String lastName) {
		super(age, firstName, lastName);
		
	}



	public String getEmpType() {
		return empType;
	}



	public void setEmpType(String empType) {
		this.empType = empType;
	}



	
	
	
	
	

	

}
