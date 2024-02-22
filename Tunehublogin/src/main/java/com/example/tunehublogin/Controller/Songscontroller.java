package com.example.tunehublogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tunehublogin.entities.Song;
import com.example.tunehublogin.services.Songservice;

@Controller
public class Songscontroller {
	@Autowired
	Songservice srv;
	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Song song) {
		boolean status=srv.songExists(song.getName());
		if(status==false) {
		srv.addsong(song);
		return "songsuccess";
	
	}
		else {
			return "songfail";
		}
	}
	@GetMapping("/view-song")
	public String fetchSongs(Model model){
		
		List<Song> list=srv.fetchSongs();
		model.addAttribute("Song",list);
		//System.out.println(list);
		return "displaysong";
	}
	
	@GetMapping("/song")
	public String viewsong(Model model) {

		List<Song> list=srv.fetchSongs();
		model.addAttribute("Song",list);
		boolean primestatus=true;
		if(primestatus==true) {
		
		return "viewsong";
	
	}
		else {
			return "makepayment";
		}
	}

}
