package com.example.tunehublogin.services;

import java.util.List;

import com.example.tunehublogin.entities.PlayList;
import com.example.tunehublogin.entities.Song;

public interface Playlistservice {

	public void addplaylist(PlayList playlist);
    public List<PlayList> fetchPlaylist();
	
	
}
