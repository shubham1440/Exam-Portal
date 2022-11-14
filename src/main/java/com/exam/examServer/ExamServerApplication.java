package com.exam.examServer;

//import org.springframework.boot.CommandLineRunner;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.exam.examServer.Models.Role;
//import com.exam.examServer.Models.User;
//import com.exam.examServer.Models.UserRole;
//import com.exam.examServer.Services.UserService;

@SpringBootApplication
public class ExamServerApplication {

	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		
		SpringApplication.run(ExamServerApplication.class, args);
		System.out.println("Starting code --->");
		
	}
	
	
	public void run(String... args)throws Exception
	{
//  		System.out.println("Starting code --->");
//		
//		User user = new User();
//		
//		user.setFirstName("Shubham");
//		user.setLastName("Kaushik");
//		user.setUsername("shubham007");
//		user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
//		user.setEmail("shubhamkaushik@gmail.com");
//		user.setProfile("default.png");
//		user.setPhone("1234567890");
//		
//		Role role1 = new Role();
//		
//		role1.setRoleId(01L);
//		role1.setRoleName("ADMIN");
//		
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		
//		userRole.setRole(role1);
//
//		userRole.setUser(user);
//		
//		userRoleSet.add(userRole);
//		
//		
//				
//		User user1 = this.userService.createUser(user,userRoleSet);
//		
//		System.out.println(user1.getUsername());
//  		
//  		
//		
//		
		//this starting line
	}
	
		
	

}
