package com.revature.beans;

public class BearWithConstructor extends Bear {
	
	public BearWithConstructor(Cave cave) {
		super();
		this.cave = cave;
	}

	@Override
	public String toString() {
		return "BearWithConstructor [id=" + id + ", name=" + name + ", cave=" + cave + "]";
	}

	
}
