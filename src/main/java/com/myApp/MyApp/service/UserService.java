package com.myApp.MyApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myApp.MyApp.Model.UserEntity;
import com.myApp.MyApp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public boolean registerUser(UserEntity user){
		UserEntity u=userRepo.save(user);
		return u==null? false: true;
	}
	public UserEntity validateUser(String email,String password){
		
		UserEntity usr=userRepo.findUserByEmail(email);
		if(usr!=null){
			if(password.equals(usr.getPassword())){
				return usr;
			}
		}
		return null;
	}

}
