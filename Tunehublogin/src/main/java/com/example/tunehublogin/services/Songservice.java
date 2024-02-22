package com.example.tunehublogin.services;

import java.util.List;

import com.example.tunehublogin.entities.Song;


public interface Songservice {
	public String addsong(Song song);
	public boolean songExists(String name);
	public List<Song> fetchSongs();
	public void updatesong(Song song);
}
