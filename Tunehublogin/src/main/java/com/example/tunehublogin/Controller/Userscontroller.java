package com.example.tunehublogin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tunehublogin.entities.Song;
import com.example.tunehublogin.entities.Users;
import com.example.tunehublogin.services.Songservice;
import com.example.tunehublogin.services.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class Userscontroller {
	 @Autowired
		UserService userv;
	 @Autowired
		Songservice srv;
		@PostMapping("/register")
		public String adduser(@ModelAttribute Users user)
		{
			boolean userstatus=userv.emailExists(user.getEmail());
					if(userstatus==false) {
						userv.addUser(user);
						return "registersuccess";
					}
					else {
						//System.out.println("User is already exist");
						return "registerfail";
					}

	}
		@PostMapping("/login")
		public String validateUser(@RequestParam String email,
				@RequestParam String 
				Password,HttpSession session) 
		{
			if(userv.validateUser(email, Password)==true) {
				session.setAttribute("email", email);
				
			if(userv.getRole(email).equals("admin")) {
				
			return "adminhome";
			}
			else {
				return "customerhome";
			}
		}
			else {
				return "loginfail";
			}
		}	
		@GetMapping("/exploresong")
		public String exploreSongs (HttpSession session,Model model)

		{
			String email=(String) session.getAttribute("email");

			 Users user =userv.getUser(email);

		boolean userStatus = user.isPremium();

		if(userStatus == true) {

			List<Song> list=srv.fetchSongs();
			model.addAttribute("Song",list);

		return "displaysong";
		}
		else {
			
			return "makepayment";
		}

		}

		}
		




