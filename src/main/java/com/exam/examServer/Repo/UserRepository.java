package com.exam.examServer.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examServer.Models.User;


public interface UserRepository extends JpaRepository<User,Long> {
	
	public User findByUsername(String username);

}
