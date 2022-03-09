package com.ecommerce.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.java.model.SignupLogin;
import com.ecommerce.java.service.SignupLoginService;

@RestController
@RequestMapping("/grocerystore")
public class SignupLoginController {

	@Autowired
	SignupLoginService signupLoginService;
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody SignupLogin details){
		
		signupLoginService.handleSignup(details);
		return ResponseEntity.ok("Successful");
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody SignupLogin details){
		
		String userrole = signupLoginService.handleLogin(details);
		return ResponseEntity.ok(userrole);
	}
}
