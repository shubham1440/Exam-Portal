package com.exam.examServer.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examServer.Auth.Utils.JwtUtils;
import com.exam.examServer.Models.User;
import com.exam.examServer.Models.jwtRequest;
import com.exam.examServer.Models.jwtResponse;
import com.exam.examServer.Services.Impl.UserSecurityImp;
import com.exam.examServer.common.Exception.UserNotFoundException;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserSecurityImp userSecurityImp;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody jwtRequest JwtRequest) throws Exception
	{
		try {
			
			authenticate(JwtRequest.getUsername(), JwtRequest.getPassword());
			
		} catch (UserNotFoundException e) {
			
			e.printStackTrace();
			throw new Exception("User Not Found");
		}
		
		/***
		 * Authenticate User
		 */
		
		UserDetails userDetails = this.userSecurityImp.loadUserByUsername(JwtRequest.getUsername());
		
		String token = this.jwtUtils.generateToken(userDetails);
		
		
		return ResponseEntity.ok(new jwtResponse(token));
		
	}
	
	private void authenticate(String username,String password) throws Exception
	{
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		} catch (DisabledException e) {
			throw new Exception("USER DISABLE"+e.getMessage());
		}catch (BadCredentialsException e) {
			throw new Exception("Invalid Credential"+e.getMessage());
		}
	}
	
	/**
	 * 
	 * **/
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return (User) this.userSecurityImp.loadUserByUsername(principal.getName());
	}
	
	

}
