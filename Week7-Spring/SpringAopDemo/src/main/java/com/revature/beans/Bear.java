package com.revature.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Bear implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static boolean isWinter = false;
	private boolean isFull = true;
	private boolean isAwake = true;

	public Bear() {
		super();
	}

	public Bear(boolean isFull, boolean isAwake) {
		super();
		this.isFull = isFull;
		this.isAwake = isAwake;
	}

	public static boolean isWinter() {
		return isWinter;
	}

	public static void setWinter(boolean isWinter) {
		Bear.isWinter = isWinter;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	public boolean isAwake() {
		return isAwake;
	}

	public void setAwake(boolean isAwake) {
		this.isAwake = isAwake;
	}
	
	public void bearHibernates() {
		if(isWinter) {
			System.out.println("zzz");
		} else {
			throw new RuntimeException("Bears hibernate in the winter");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isAwake ? 1231 : 1237);
		result = prime * result + (isFull ? 1231 : 1237);
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
		Bear other = (Bear) obj;
		if (isAwake != other.isAwake)
			return false;
		if (isFull != other.isFull)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bear [isFull=" + isFull + ", isAwake=" + isAwake + "]";
	}
	
}
