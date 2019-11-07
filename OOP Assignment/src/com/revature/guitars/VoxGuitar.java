package com.revature.guitars;

//using extends keyword to inherit the methods and objects of the guitar class.
//This is an example of INHERITANCE.
public class VoxGuitar extends Guitar {
	
	private String voxType;
	
	public String getVoxType() {
		return voxType;
	}

	public void setVoxType (String voxType) {
		this.voxType = voxType;
	}
	
	public void playGuitar() {
		System.out.println("Playing some nice VOX sounds now.");
	}
		
}
