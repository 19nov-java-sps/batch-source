package com.revature.models;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Track implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String artist;
	private int duration;
	
	public Track() {
		super();
	}

	public Track(int id, String title, String artist, int duration) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.duration = duration;
	}
	
	public Track(String title, String artist, int duration) {
		super();
		this.title = title;
		this.artist = artist;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + duration;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Track other = (Track) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (duration != other.duration)
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", title=" + title + ", artist=" + artist + ", duration=" + duration + "]";
	}
	
	
	
	
	
}
