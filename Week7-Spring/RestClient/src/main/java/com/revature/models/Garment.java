package com.revature.models;

import java.io.Serializable;


import org.springframework.stereotype.Component;

@Component
public class Garment implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	
	private Size size;
	
	private String brand;
	
	private GarmentType type;
	
	private String color;

	public Garment() {
		super();
	}

	public Garment(int id, Size size, String brand, GarmentType type, String color) {
		super();
		this.id = id;
		this.size = size;
		this.brand = brand;
		this.type = type;
		this.color = color;
	}
	
	public Garment(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public GarmentType getType() {
		return type;
	}

	public void setType(GarmentType type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + id;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Garment other = (Garment) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (id != other.id)
			return false;
		if (size != other.size)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Garment [id=" + id + ", size=" + size + ", brand=" + brand + ", type=" + type + ", color=" + color
				+ "]";
	}
	
	
	
	
}
