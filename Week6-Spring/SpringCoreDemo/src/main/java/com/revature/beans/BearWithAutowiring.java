package com.revature.beans;

public class BearWithAutowiring extends Bear {

	public void setCave(Cave c) {
		this.cave = c;
	}

	@Override
	public String toString() {
		return "BearWithAutowiring [id=" + id + ", name=" + name + ", cave=" + cave + "]";
	}

	
	
}
