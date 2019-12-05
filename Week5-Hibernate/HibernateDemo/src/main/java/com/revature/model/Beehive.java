package com.revature.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Beehive implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="beehive_id")
	private int id;
	
	private int weight;
	
	public Beehive() {
		super();
	}

	public Beehive(int id, int weight) {
		super();
		this.id = id;
		this.weight = weight;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + weight;
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
		Beehive other = (Beehive) obj;
		if (id != other.id)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Beehive [id=" + id + ", weight=" + weight + "]";
	}
	

}
