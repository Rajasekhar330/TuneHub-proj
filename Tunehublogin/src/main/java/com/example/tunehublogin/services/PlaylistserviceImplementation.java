package com.example.tunehublogin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehublogin.entities.PlayList;
import com.example.tunehublogin.repositories.Playlistrepository;


@Service
public class PlaylistserviceImplementation implements Playlistservice{
	@Autowired
	Playlistrepository prepo;

	@Override
	public void addplaylist(PlayList playlist) {
		// TODO Auto-generated method stub
		prepo.save(playlist);
		
	}

	@Override
	public List<PlayList> fetchPlaylist() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

	
}
	

	


