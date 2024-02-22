package com.example.tunehublogin.services;

import com.example.tunehublogin.entities.Users;

public interface UserService {
	public String addUser(Users user);
	public boolean emailExists(String email);
	public boolean validateUser(String email,String Password);
	public String getRole(String email);
	public Users getUser(String email);
	public void updateUser(Users user);

}
