package com.revature.models;

public class Pending {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private int id;
	private String reason;
	private int amount;
	
	
	public Pending() {
		super();
	}

	public Pending(String username,int id, String reason, int amount) {
		super();
		this.username = username;
		this.id = id;
		this.reason = reason;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Pending [username=" + username + ", id=" + id + ", reason=" + reason + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + id;
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Pending other = (Pending) obj;
		if (amount != other.amount)
			return false;
		if (id != other.id)
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
