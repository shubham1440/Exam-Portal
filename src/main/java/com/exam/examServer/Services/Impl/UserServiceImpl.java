package com.exam.examServer.Services.Impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examServer.Models.User;
import com.exam.examServer.Models.UserRole;
import com.exam.examServer.Repo.RoleRepository;
import com.exam.examServer.Repo.UserRepository;
import com.exam.examServer.Services.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired(required=true)
	private UserRepository userRepository;
	@Autowired(required=true)
	private RoleRepository roleRepository;
	
	
	
	@Override
	public User createUser(User user,Set<UserRole> userRoles) throws Exception {
		
		User local = this.userRepository.findByUsername(user.getUsername());
		
		if(local!=null)
		{
			System.out.println("User Already there !!");
			
			throw new Exception("User Already present !!");
		}
		else {
			
			//create user
			//new user created
			
			for(UserRole ur:userRoles)
			{
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			
			local = this.userRepository.save(user);
		}
				
		return local;
	}
	
	//getting user by name
	@Override
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	}
	
	//delete user by id
	public void deleteUser(Long userId)
	{
		this.userRepository.deleteById(userId);
	}
	
	@Override
	public User updateUser(User oldUser) {
		// TODO Auto-generated method stub
		return this.userRepository.save(oldUser);
	}
	
}
