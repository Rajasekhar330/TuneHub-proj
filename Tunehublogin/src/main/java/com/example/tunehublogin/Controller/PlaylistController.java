package com.example.tunehublogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tunehublogin.entities.PlayList;
import com.example.tunehublogin.entities.Song;
import com.example.tunehublogin.services.Playlistservice;
import com.example.tunehublogin.services.Songservice;
@Controller
public class PlaylistController {
	@Autowired
   Playlistservice pserv;
	
	@Autowired
	Songservice srv;
	
   @GetMapping("/createplaylist")
   public String createplaylist(Model model) {
	   //fetching the songs using song service
	   List<Song> list=srv.fetchSongs();
	   //Adding the songs in the model
		model.addAttribute("songslist",list);
		//sending createplaylist
		return "createplaylist";
	   
   }
   @PostMapping("/addplaylist")
   public String addplaylist(@ModelAttribute PlayList playlist) {
	   pserv.addplaylist(playlist);
	  List<Song> songslist=playlist.getSong();
	  for(Song songs: songslist) {
		  songs.getPlaylist().add(playlist);
		  srv.updatesong(songs);
	  }
	   return "playlistsuccess";
   }
   @GetMapping("/viewplaylist")
   public String viewPlaylist(Model model) {
	   List<PlayList> plist=pserv.fetchPlaylist();
	   model.addAttribute("plist",plist);
	   return "viewplaylist";
   }

}
