package com.example.tunehublogin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehublogin.entities.Song;
import com.example.tunehublogin.repositories.SongRepository;
@Service
public class SongserviceImplementation implements Songservice{
	@Autowired
	SongRepository srp;

	@Override
	public String addsong(Song song) {
		srp.save(song);
		return "song is added ";
	}

	@Override
	public boolean songExists(String name) {
		
		if(srp.findByName(name)==null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public List<Song> fetchSongs() {
		List<Song> list1 =srp.findAll();
		return list1;
	}

	@Override
	public void updatesong(Song song) {
		srp.save(song);
		// TODO Auto-generated method stub
		
	}

}
