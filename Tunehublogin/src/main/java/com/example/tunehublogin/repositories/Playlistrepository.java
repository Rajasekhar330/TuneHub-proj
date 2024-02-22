package com.example.tunehublogin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunehublogin.entities.PlayList;

public interface Playlistrepository extends JpaRepository<PlayList,Integer>{
	
}