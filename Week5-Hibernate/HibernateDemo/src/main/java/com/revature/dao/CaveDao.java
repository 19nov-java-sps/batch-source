package com.revature.dao;

import java.util.List;

import com.revature.model.Cave;

public interface CaveDao {
	
	public List<Cave> getCaves();
	public Cave getCaveById(int id);
	public int createCave(Cave cave);
	public void updateCave(Cave c);
	public void deleteCave(int caveId);

}
