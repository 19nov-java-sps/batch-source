package com.revature.io;

public class Pen {
	
	private String inkColorString;
	private boolean isBallpoint;
	private int pointSize;
	
	public Pen() {
		super();
	}
	
	

	public Pen(Integer id, String inkColorString, boolean isBallpoint, int pointSize) {
		super();
		this.inkColorString = inkColorString;
		this.isBallpoint = isBallpoint;
		this.pointSize = pointSize;
	}



	public String getInkColorString() {
		return inkColorString;
	}

	public void setInkColorString(String inkColorString) {
		this.inkColorString = inkColorString;
	}

	public boolean isBallpoint() {
		return isBallpoint;
	}

	public void setBallpoint(boolean isBallpoint) {
		this.isBallpoint = isBallpoint;
	}

	public int getPointSize() {
		return pointSize;
	}

	public void setPointSize(int pointSize) {
		this.pointSize = pointSize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inkColorString == null) ? 0 : inkColorString.hashCode());
		result = prime * result + (isBallpoint ? 1231 : 1237);
		result = prime * result + pointSize;
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
		Pen other = (Pen) obj;
		if (inkColorString == null) {
			if (other.inkColorString != null)
				return false;
		} else if (!inkColorString.equals(other.inkColorString))
			return false;
		if (isBallpoint != other.isBallpoint)
			return false;
		if (pointSize != other.pointSize)
			return false;
		return true;
	}
	
	
}


