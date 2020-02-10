package com.myApp.MyApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myApp.MyApp.Model.ResponseMessage;
import com.myApp.MyApp.Model.UserEntity;
import com.myApp.MyApp.Model.UserModel;
import com.myApp.MyApp.service.EmailService;
import com.myApp.MyApp.service.UserService;

@RestController
@RequestMapping("/api")
public class MyAppController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailService;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseMessage> registerUser(@RequestBody UserEntity user){
		user.toString();
		System.out.println("User email : "+ user.getEmail());
		boolean isSuccessful=userService.registerUser(user);
		if(isSuccessful) {
			emailService.sendMail(user.getEmail(), "Registration Successful", "Dear "+user.getFirstName()+",\n\n "
					+ "You have registered Successfully.\n"
					+ "Please login.\n\n"
					+ "Thanks and Regards\n"
					+ "Team MyApp");
		}
		return isSuccessful? new ResponseEntity<ResponseMessage>(new ResponseMessage("Registered Successful, please login",HttpStatus.OK), new HttpHeaders(), HttpStatus.OK) : new ResponseEntity<ResponseMessage>(new ResponseMessage("Something went wrong, Please try again",HttpStatus.GONE), new HttpHeaders(), HttpStatus.GONE);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserEntity> login(@RequestBody UserEntity user){
		UserEntity usr=userService.validateUser(user.getEmail(),user.getPassword());
		
		return usr!=null? new ResponseEntity<UserEntity>(usr, new HttpHeaders(), HttpStatus.OK) :   new ResponseEntity<UserEntity>(usr, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
		
	}
	@GetMapping("/test")
	public UserEntity test(){
		UserEntity u=new UserEntity();
		u.setEmail("a@tcs.com");
		u.setFirstName("anup");
		u.setId(1L);
		u.setLastName("sad");
		u.setPassword("abc");
		return u;
	}
	@GetMapping("/test1")
	public ResponseEntity<ResponseMessage> test1(){
		
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Registered Successful",HttpStatus.OK), new HttpHeaders(), HttpStatus.OK) ;
	}
	@PostMapping(path="/rtest")
	public ResponseEntity<ResponseMessage> rTest(@RequestBody UserModel u){
		System.out.println("User email : "+ u.getEmail());
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Registered Successful",HttpStatus.OK), new HttpHeaders(), HttpStatus.OK) ;
		
	}
}
