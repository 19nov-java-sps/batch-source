package com.revature.daos;

import java.util.List;

import com.revature.models.Track;

public interface TrackDao {
	
	public List<Track> getAll();
	public Track getById(int id);
	// other crud methods

}
