
public class Surgeon extends Doctor {

	public Surgeon(String name) {
		super(name); 
	}
	
	public Surgeon(String name, String medicalSchool) {
		super(name, medicalSchool); 
	}
	
	public Surgeon(String name, String medicalSchool, String residency) {
		super(name, medicalSchool, residency); 
	}
	
	@Override
	public void comfortPatient() {
		// TODO Auto-generated method stub
		System.out.println("It's going to be alright."); 
	}

	@Override 
	public void treatPatient() {
		System.out.println("Perform surgery."); 
	}
	
	@Override 
	public void collectPayment() {
		System.out.println("Copy insurance information.");
	}
	
	@Override 
	public String toString() {
		return "This is the surgeon Dr. " + getName(); 
	}
}
