package com.example.tunehublogin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunehublogin.entities.Song;
import com.example.tunehublogin.entities.Users;

public interface SongRepository extends JpaRepository<Song,Integer>{
	 public Song findByName(String name);

}
