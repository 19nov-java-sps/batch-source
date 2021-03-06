package com.revature.dao;

import java.util.List;

import com.revature.model.Bear;

public interface BearDao {
	
	public List<Bear> getBears();
	public Bear getBearById(int id);
	public int createBear(Bear b);
	public void updateBear(Bear b);
	public void deleteBearById(int bearId);
	public List<Bear> getBearsByName(String name);
	public List<Bear> getYBears();
	public long getBearCount();
	
}
