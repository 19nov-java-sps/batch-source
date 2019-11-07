
public class Pediatrician extends Physician {
	
	private String specialty = "Pediatrics";
	
	public Pediatrician(String name) {
		super(name); 
	}
	public Pediatrician(String name, String medicalSchool) {
		super(name, medicalSchool); 
	}
	public Pediatrician(String name, String medicalSchool, String residency) {
		super(name, medicalSchool, residency); 
	}
	
	/*
	 * The overrided methods show polymorphism
	 */
	
	@Override 
	public void treatPatient() {
		System.out.println("Give vaccinations."); 
	}
	
	@Override 
	public void comfortPatient() {
		System.out.println("Give lollipop."); 
	}
	
	@Override 
	public String toString() {
		return "this is the physician Dr. " + getName() + " and his specialty is "
					                        + this.specialty; 
	}
}
