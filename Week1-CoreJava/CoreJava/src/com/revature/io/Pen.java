package com.revature.io;

import java.io.Serializable;

public class Pen implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 169078196347036978L;
	private int id;
	private String inkColor;
	private boolean isBallpoint;
	private int pointSize;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((inkColor == null) ? 0 : inkColor.hashCode());
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
		if (id != other.id)
			return false;
		if (inkColor == null) {
			if (other.inkColor != null)
				return false;
		} else if (!inkColor.equals(other.inkColor))
			return false;
		if (isBallpoint != other.isBallpoint)
			return false;
		if (pointSize != other.pointSize)
			return false;
		return true;
	}

	public Pen() {
		super();
	}
	public Pen(int id, String inkColor, boolean isBallpoint, int pointSize) {
		super();
		this.id = id;
		this.inkColor = inkColor;
		this.isBallpoint = isBallpoint;
		this.pointSize = pointSize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInkColor() {
		return inkColor;
	}

	public void setInkColor(String inkColor) {
		this.inkColor = inkColor;
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
	public String toString() {
		return "Pen [id=" + id + ", inkColor=" + inkColor + ", isBallpoint=" + isBallpoint + ", pointSize=" + pointSize
				+ "]";
	}
	
}
