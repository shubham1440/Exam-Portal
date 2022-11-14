package com.exam.examServer.controller;


import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examServer.Models.Role;
import com.exam.examServer.Models.User;
import com.exam.examServer.Models.UserRole;
import com.exam.examServer.Services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/")
	public User CreateUser(@RequestBody User user) throws Exception
	{
		user.setProfile("default.png");
		
		/**
		 * Password bCryptPassword
		 * */
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		Set<UserRole> roles = new HashSet<>();
		
		Role role = new Role();
		role.setRoleId(02L);
		role.setRoleName("NORMAL");
		
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		
		
		return this.userService.createUser(user,roles);
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	
	// delete user by id
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		this.userService.deleteUser(userId);
	}
	
	//update api
	@PutMapping("/{username}")
	public User updateUser(@RequestBody User user,@PathVariable("username")String username) {
		User oldUser=this.userService.getUser(username);
	oldUser.setEmail(user.getEmail());
	oldUser.setFirstName(user.getFirstName());
	oldUser.setLastName(user.getLastName());
	oldUser.setPassword(user.getPassword());
	oldUser.setPhone(user.getPhone());
	oldUser.setProfile(user.getProfile());

	return this.userService.updateUser(oldUser);
	}

}
