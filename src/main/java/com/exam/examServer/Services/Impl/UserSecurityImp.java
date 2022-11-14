package com.exam.examServer.Services.Impl;

import java.util.Locale.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.examServer.Models.User;
import com.exam.examServer.Repo.UserRepository;

@Service
public class UserSecurityImp implements UserDetailsService {
	//not working 
//	public static final Category s_logger = Category.getInstance(UserSecurityImp.class);

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepository.findByUsername(username);
		if(user==null)
	    {
	    System.out.println("User Not Found");
	    throw new UsernameNotFoundException("No User found!!");
	    }
		return user;
	}

}
