package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
//@Table(name="home")
public class Cave implements Serializable {
	
	/*
	 * Entity *required - defines your class as a db entity corresponding to a table
	 * Id *required - defines you Primary Key 
	 * Column - allows you to designate column configuration, e.g. column name
	 * Table - allows you to designate table configuration, e.g. table name
	 * Transient - prevents a particular field from persisting
	 * ManyToMany/OneToMany/etc. - allow us to define multiplicity relationships between entities 
	 * GeneratedValue - allows you to define a generation strategy for pk's
	 * JoinColumn/JoinTable - allows you to specify columns/tables designated by FK relationships 
	 */

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cave_id")
	private int id;
	
	@Column(name="cave_name")
//	@Transient
	private String name;
	
	
	public Cave() {
		super();
	}
	
	public Cave(String name) {
		super();
		this.name = name;
	}
	
	public Cave(int id) {
		super();
		this.id = id;
	}

	public Cave(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Cave other = (Cave) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cave [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
