package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.Track;

@Service
public class TrackService {
	
	private List<Track> tracks = new ArrayList<>();
	
	public TrackService() {
		tracks.add(new Track(1,"PDA", "Interpol",165));
		tracks.add(new Track(2,"Big Mouth Strikes Again", "The Smiths",187));
		tracks.add(new Track(3,"Under the Cover of Darkness", "The Strokes",162));
		tracks.add(new Track(4,"Blue Monday", "New Order",107));
	}

	public List<Track> getAll(){
		return new ArrayList<Track>(tracks);
	}
	
	public Track getById(int id) {
		for(Track t: tracks) {
			if(t.getId()==id) {
				return t;
			}
		}
		return null;
	}
	
	public void create(Track t) {
		int maxId = tracks.stream().mapToInt((track)->track.getId()).max().getAsInt();
		t.setId(++maxId);
		tracks.add(t);
	}
	
}
