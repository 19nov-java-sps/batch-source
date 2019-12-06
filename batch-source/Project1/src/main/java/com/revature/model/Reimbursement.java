package com.revature.model;

import java.io.Serializable;
import java.sql.Date;

public class Reimbursement implements Serializable{

	private static final long serialVersionUID = 1L;

	private int reimId;
	private String descr;
	private Date date;
	private String status;
	private double sum;
	private String fName1;
	private String lName1;
	
	
	public String getfName() {
		return fName1;
	}
	public void setfName(String fName) {
		this.fName1 = fName;
	}
	public String getlName() {
		return lName1;
	}
	public void setlName(String lName) {
		this.lName1 = lName;
	}
	private int id;
	private String fName;
	private String lName;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(int reimId, String descr, Date date, String status, double sum, int emplId, String fName, String lName) {
		super();
		this.reimId = reimId;
		this.descr = descr;
		this.date = date;
		this.status = status;
		this.sum = sum;
		this.id = emplId;
		this.fName1 = fName;
		this.lName1 = lName;
	}
	public int getReimId() {
		return reimId;
	}
	public void setReimId(int reimId) {
		this.reimId = reimId;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result + ((fName1 == null) ? 0 : fName1.hashCode());
		result = prime * result + id;
		result = prime * result + ((lName1 == null) ? 0 : lName1.hashCode());
		result = prime * result + reimId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sum);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Reimbursement other = (Reimbursement) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (fName1 == null) {
			if (other.fName1 != null)
				return false;
		} else if (!fName1.equals(other.fName1))
			return false;
		if (id != other.id)
			return false;
		if (lName1 == null) {
			if (other.lName1 != null)
				return false;
		} else if (!lName1.equals(other.lName1))
			return false;
		if (reimId != other.reimId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(sum) != Double.doubleToLongBits(other.sum))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimId=" + reimId + ", descr=" + descr + ", date=" + date + ", status=" + status
				+ ", sum=" + sum + ", id=" + id + ", fName=" + fName1 + ", lName=" + lName1 + "]";
	}
	
	
	
	
	
}
