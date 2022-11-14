package com.exam.examServer.Services;

import java.util.Set;
import com.exam.examServer.Models.User;
import com.exam.examServer.Models.UserRole;

public interface UserService {
	
	//creating user
	
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	//get user by name
	public User getUser(String username);
	
	//delete user by id
	public void deleteUser(Long userId);
	
	//update user data
	public User updateUser(User oldUser);
}
