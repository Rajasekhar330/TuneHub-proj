package com.example.tunehublogin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehublogin.entities.Users;
import com.example.tunehublogin.repositories.UsersRepository;

@Service
public class UsersServiceImplementation implements UserService{
	
	@Autowired
	UsersRepository repo;

	
	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "user is created and saved";
	}
	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null) {
		return false;
	}
		else {
			return true;
		}
}
	@Override
	public boolean validateUser(String email,String Password) {
		Users user=repo.findByEmail(email);
		String db_password=user.getPassword();
		if(db_password.equals(Password)) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public String getRole(String email) {
		
		return (repo.findByEmail(email).getRole());
	}
	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
	}
	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}
	
	}

