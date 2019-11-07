
public class Physician extends Doctor {
	
	public Physician(String name) {
		super(name);  
	}
	
	public Physician(String name, String medicalSchool) {
		super(name, medicalSchool); 
	}
	
	public Physician(String name, String medicalSchool, String residency) {
		super(name, medicalSchool, residency); 
	}
	
	/*
	 * The overrided methods show polymorphism
	 */
	
	@Override
	public void comfortPatient() {
		System.out.println("It's going to be okay.");
	}
	
	@Override 
	public void treatPatient() {
		System.out.println("Prescribing medication."); 
	}
	
	@Override 
	public void collectPayment() {
		System.out.println("Copy insurance information."); 
	}
	
	@Override
	public String toString() {
		return "This is the physician Dr. " + getName(); 
	}
}
