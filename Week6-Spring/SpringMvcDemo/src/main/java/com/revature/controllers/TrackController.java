package com.revature.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.exceptions.TrackNotFoundException;
import com.revature.models.Track;
import com.revature.services.TrackService;

@Controller
@CrossOrigin
public class TrackController {
	
	@Autowired
	private TrackService trackService;
	
	@RequestMapping(method=RequestMethod.GET, value="/tracks")
	@ResponseBody
	public List<Track> getAllTracks(@RequestParam(name="artist",required=false)String artist){
//		System.out.println(artist);
		if(artist!=null) {
			return trackService.getAll().stream()
						.filter((t)->artist.equals(t.getArtist()))
						.collect(Collectors.toList());
		}
		return trackService.getAll();
	}
	
	@GetMapping("/tracks/{id}")
	@ResponseBody
	public Track getTrackById(@PathVariable("id")int id) {
		Track track = trackService.getById(id);
		if(track == null) {
			throw new TrackNotFoundException();
		}
		return track;
	}
	
	/*
	@PostMapping("/tracks")
	@ResponseBody
	public String addTrack(@RequestParam("artist")String artist, @RequestParam("title")String title, @RequestParam("duration")int duration) {
		Track newTrack = new Track(title, artist,duration);
		trackService.create(newTrack);
		return "added track \""+title+"\"";
	}
	
	@PostMapping(value="/tracks",consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String addTrack(@RequestBody Track track) {
		trackService.create(track);
		return "added track \""+track.getTitle()+"\"";
	}
	*/
	
	@PostMapping(value="/tracks",consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addTrack(@RequestBody Track track) {
		trackService.create(track);
		return new ResponseEntity<>("added track \""+track.getTitle()+"\"",HttpStatus.CREATED);
	}
	
	

}
