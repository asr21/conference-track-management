package com.example.conferencetrackmanagement.model;

import java.util.List;

public class Conference {
	
	public Conference(List<Track> tracks) {
		this.tracks = tracks;
	}

	List<Track> tracks;

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	

}
